package medievalconclave.medievalconclave.effect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;

public class StunEffect extends Effect {
    public StunEffect() {
        super(EffectType.HARMFUL, 0xADD8E6); // Blue color for stun effect
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide) {
            CompoundNBT data = entity.getPersistentData();

            // Save the initial position
            if (!data.contains("StunX")) {
                data.putDouble("StunX", entity.getX());
                data.putDouble("StunY", entity.getY());
                data.putDouble("StunZ", entity.getZ());
            }

            // Keep teleporting back to original position
            double x = data.getDouble("StunX");
            double y = data.getDouble("StunY");
            double z = data.getDouble("StunZ");

            if (entity instanceof ServerPlayerEntity) {
                ((ServerPlayerEntity) entity).teleportTo(x, y, z);
            } else {
                entity.setPos(x, y, z);
            }
        }
        super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // Apply effect every tick
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeModifierManager manager, int amplifier) {
        super.removeAttributeModifiers(entity, manager, amplifier);

        // Remove stored stun position when effect ends
        CompoundNBT data = entity.getPersistentData();
        data.remove("StunX");
        data.remove("StunY");
        data.remove("StunZ");
    }
}
