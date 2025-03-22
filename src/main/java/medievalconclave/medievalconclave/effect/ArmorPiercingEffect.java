package medievalconclave.medievalconclave.effect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.InstantEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.StringTextComponent;

public class ArmorPiercingEffect extends InstantEffect {
    public ArmorPiercingEffect() {
        super(EffectType.HARMFUL, 0x8B0000); // Dark red color
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level.isClientSide) {
            CompoundNBT data = entity.getPersistentData();

            // Retrieve stored raw damage (pre-armor)
            float rawDamage = data.getFloat("RawDamage");

            // Only apply if raw damage exists
            if (rawDamage > 0) {
                // Calculate the piercing damage
                float damageBonus = rawDamage * (0.05f * (amplifier + 1)); // 5% per level

                // Combine the original damage and the piercing damage
                float totalDamage = rawDamage + damageBonus;

                // Apply combined damage as one hit
                DamageSource piercingSource = new DamageSource("medievalconclave.armor_piercing").bypassArmor();
                entity.hurt(piercingSource, totalDamage);

                // Optional: Show debug message
                if (entity instanceof PlayerEntity) {
                    ((PlayerEntity) entity).displayClientMessage(new StringTextComponent("Total Damage: " + totalDamage), true);
                }

                // Remove the stored damage to prevent double application
                data.remove("RawDamage");
            }
        }
    }

    @Override
    public boolean isInstantenous() {
        return true; // Effect applies instantly
    }
}