package medievalconclave.medievalconclave.effect;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectCategory;

public class StunEffect extends MobEffect {
    public StunEffect() {
        super(MobEffectCategory.HARMFUL, 0xADD8E6); // Blue color for stun effect
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            CompoundTag data = entity.getPersistentData();

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

            if (entity instanceof Player) {
                ((Player) entity).teleportTo(x, y, z);
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
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap manager, int amplifier) {
        super.removeAttributeModifiers(entity, manager, amplifier);

        // Remove stored stun position when effect ends
        CompoundTag data = entity.getPersistentData();
        data.remove("StunX");
        data.remove("StunY");
        data.remove("StunZ");
    }
}
