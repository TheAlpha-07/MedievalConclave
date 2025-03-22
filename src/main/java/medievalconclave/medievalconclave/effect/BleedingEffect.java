package medievalconclave.medievalconclave.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

public class BleedingEffect extends Effect {
    public static final DamageSource BLEEDING = (new DamageSource("medievalconclave.bleeding")).bypassArmor();

    public BleedingEffect() {
        super(EffectType.HARMFUL, 9109504);
    }

    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier) {
        entityLivingBaseIn.hurt(BLEEDING, 1.0F + (float)amplifier);
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 40 == 0;
    }
}

