package medievalconclave.medievalconclave.effect;

import net.minecraft.world.entity.LivingEntity;


import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class BleedingEffect extends MobEffect {


    public BleedingEffect() {
        super(MobEffectCategory.HARMFUL, 9109504);
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        DamageSource piercingSource = entity.damageSources().starve();
        entity.hurt(piercingSource, 1.0F + (float)amplifier);
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }
}

