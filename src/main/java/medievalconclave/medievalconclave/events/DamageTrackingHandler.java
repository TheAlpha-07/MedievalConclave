package medievalconclave.medievalconclave.events;


import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;

public class DamageTrackingHandler {
    public static void register() {
        MinecraftForge.EVENT_BUS.register(new DamageTrackingHandler());
    }

    @SubscribeEvent
    public void onEntityHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (!entity.level.isClientSide) {
            CompoundNBT data = entity.getPersistentData();

            // Store the raw damage that is applied (pre-armor)
            data.putFloat("RawDamage", event.getAmount());
        }
    }
}