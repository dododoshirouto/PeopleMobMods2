package site.dodoneko.peoplemobsmod2.renderer;

import net.minecraft.client.model.IronGolemModel;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import site.dodoneko.peoplemobsmod2.PeopleMobsMod2;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidMobRenderer;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidModel;

@OnlyIn(Dist.CLIENT)
public class PMM2_IronGolemRenderer<T extends IronGolem> extends PMM2_HumanoidMobRenderer<T, PMM2_HumanoidModel<T>> {

    IronGolemRenderer refR;
    IronGolemModel<IronGolem> refM;

    @SuppressWarnings("null")
    public PMM2_IronGolemRenderer(EntityRendererProvider.Context entity) {
        super(entity, new PMM2_HumanoidModel<>(entity.bakeLayer(PeopleMobsMod2.PMM2_HUMANOID_LAYER)), 0.7F);
    }
}