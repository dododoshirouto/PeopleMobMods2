package site.dodoneko.peoplemobsmod2.renderer;

import net.minecraft.client.model.EndermiteModel;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EndermiteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import site.dodoneko.peoplemobsmod2.PeopleMobsMod2;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidMobRenderer;
import site.dodoneko.peoplemobsmod2.base.PMM2_HumanoidModel;

@OnlyIn(Dist.CLIENT)
public class PMM2_EndermiteRenderer<T extends Endermite> extends PMM2_HumanoidMobRenderer<T, PMM2_HumanoidModel<T>> {

    EndermiteRenderer refR;
    EndermiteModel<Endermite> refM;
    
    public static float modelScale = 0.9F;
    public static float bHeight = 0.3F;
    public static void setModelScales(float scale, float height) {
        modelScale = scale;
        bHeight = height;
    }

    @SuppressWarnings("null")
    public PMM2_EndermiteRenderer(EntityRendererProvider.Context entity) {
        super(entity, new PMM2_HumanoidModel<>(entity.bakeLayer(PeopleMobsMod2.PMM2_HUMANOID_LAYER)), modelScale);
        this.getModel().bHeight = bHeight;
        this.getModel().forwardArm = true;
        this.getModel().useChildModel = isChildModel;
        this.getModel().flyFlap = doFlyFlap;
    }
    public static boolean isChildModel = false;
    public static boolean doFlyFlap = false;
    public static void setModelScales(float scale, float height, boolean isChild) {
        modelScale = scale;
        bHeight = height;
        isChildModel = isChild;
    }
    public static void setModelScales(float scale, float height, boolean isChild, boolean flyFlap) {
        modelScale = scale;
        bHeight = height;
        isChildModel = isChild;
        doFlyFlap = flyFlap;
    }


    

   @SuppressWarnings("null")
protected float getFlipDegrees(Endermite p_114352_) {
    return 180.0F;
 }
}