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
            float rawDamage = data.getFloat("RawDamage");
            long recordedTick = data.getLong("RawDamageTime");
            long currentTick = entity.level().getGameTime();

            // Only apply if damage is from this tick
            if (rawDamage > 0 && recordedTick == currentTick) {
                float damageBonus = rawDamage * (0.05f * (amplifier + 1));
                float totalDamage = rawDamage + damageBonus;

                entity.hurt(entity.damageSources().starve(), totalDamage);

                // Remove damage after use
                data.remove("RawDamage");
                data.remove("RawDamageTime");
            }
        }
    }

    @Override
    public boolean isInstantenous() {
        return true; // Effect applies instantly
    }
}