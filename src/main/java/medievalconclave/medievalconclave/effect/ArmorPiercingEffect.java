package medievalconclave.medievalconclave.effect;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectCategory;
import org.lwjgl.system.Platform;

public class ArmorPiercingEffect extends InstantenousMobEffect {
    public ArmorPiercingEffect() {
        super (MobEffectCategory.HARMFUL, 0x8B0000); // Dark red color
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            CompoundTag data = entity.getPersistentData();

            // Retrieve stored raw damage (pre-armor)
            float rawDamage = data.getFloat("RawDamage");

            // Only apply if raw damage exists
            if (rawDamage > 0) {
                // Calculate the piercing damage
                float damageBonus = rawDamage * (0.05f * (amplifier + 1)); // 5% per level

                // Combine the original damage and the piercing damage
                float totalDamage = rawDamage + damageBonus;

                // Apply combined damage as one hit
                DamageSource piercingSource = entity.damageSources().starve();
                entity.hurt(piercingSource, totalDamage);

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