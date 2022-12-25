package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import dannyandjannymod.powers.CalciumPower;

public class ReflectiveSurfaceAction extends AbstractGameAction {
    AbstractPlayer player;
    public ReflectiveSurfaceAction(AbstractPlayer p, AbstractCreature target) {
        this.duration = 0.5F;
        this.actionType = ActionType.BLOCK;
        this.target = target;
        this.player = p;
    }

    public void update() {
        if (this.duration == 0.5F && this.target != null && this.target.currentBlock > 0) {
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.player.hb.cX, this.player.hb.cY, AttackEffect.SHIELD));
            this.player.addBlock(this.target.currentBlock);
        }

        this.tickDuration();
    }
}