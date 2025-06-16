package medievalconclave.medievalconclave.effect;

import medievalconclave.medievalconclave.MedievalConclave;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;


public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MedievalConclave.MOD_ID);

    public static final RegistryObject<MobEffect> BLEEDING = EFFECTS.register("bleeding",
            BleedingEffect::new);

    public static final RegistryObject<MobEffect> STUN = EFFECTS.register("stun",
            StunEffect::new);

    public static final RegistryObject<MobEffect> ARMOR_PIERCING = EFFECTS.register("armor_piercing",
            ArmorPiercingEffect::new);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }
}
