package com.kaupenjoe.mccourse.screens;

import com.kaupenjoe.mccourse.MCCourseMod;
import com.kaupenjoe.mccourse.container.ElectrifierContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.apache.logging.log4j.LogManager;

public class ElectrifierScreen extends ContainerScreen<ElectrifierContainer>
{
    private final ResourceLocation GUI = new ResourceLocation(MCCourseMod.MOD_ID,
            "textures/gui/electrifier_gui.png");

    public ElectrifierScreen(ElectrifierContainer container, PlayerInventory inv, ITextComponent name)
    {
        super(container, inv, name);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY) {
        LogManager.getLogger().debug("EL: " + container.getEnergyLevel());
        drawString(matrixStack, Minecraft.getInstance().fontRenderer,"Energy: " +
                container.getEnergyLevel(), 28, 10, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y)
    {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        this.blit(matrixStack, i + 13, j + 9, 176, 0, 11, 64 - container.getEnergyLevel());
    }
}
