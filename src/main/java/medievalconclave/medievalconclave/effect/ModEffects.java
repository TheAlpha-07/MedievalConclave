package medievalconclave.medievalconclave.effect;

import medievalconclave.medievalconclave.MedievalConclave;
import net.minecraft.potion.Effect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS
            = DeferredRegister.create(ForgeRegistries.POTIONS, MedievalConclave.MOD_ID);

    public static final RegistryObject<Effect> BLEEDING = EFFECTS.register("bleeding",
            BleedingEffect::new);

    public static final RegistryObject<Effect> STUN = EFFECTS.register("stun",
            StunEffect::new);

    public static final RegistryObject<Effect> ARMOR_PIERCING = EFFECTS.register("armor_piercing",
            ArmorPiercingEffect::new);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
