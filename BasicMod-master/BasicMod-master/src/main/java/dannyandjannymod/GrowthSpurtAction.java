package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.powers.MetallicizePower;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.powers.GrowthSpurtPower;

public class GrowthSpurtAction extends AbstractGameAction {
    private boolean freeToPlayOnce;
    private boolean isUpgraded;
    private AbstractPlayer p;
    private int energyOnUse;

    public GrowthSpurtAction(AbstractPlayer p, boolean freeToPlayOnce, int energyOnUse, boolean isUpgraded) {
        this.p = p;
        this.freeToPlayOnce = freeToPlayOnce;
        this.duration = Settings.ACTION_DUR_XFAST;
        this.actionType = ActionType.SPECIAL;
        this.energyOnUse = energyOnUse;
        this.isUpgraded = isUpgraded;
    }

    public void update() {
        int effect = EnergyPanel.totalCount;
        if (this.energyOnUse != -1) {
            effect = this.energyOnUse;
        }

        if (this.p.hasRelic("Chemical X")) {
            effect += 2;
            this.p.getRelic("Chemical X").flash();
        }

        if (effect > 0) {
            this.addToBot(new ApplyPowerAction(p, p, new GrowthSpurtPower(p, effect), effect));
            if (isUpgraded)
                this.addToBot(new ApplyPowerAction(p, p, new MetallicizePower(p, effect), effect));

            if (!this.freeToPlayOnce) {
                this.p.energy.use(EnergyPanel.totalCount);
            }
        }

        this.isDone = true;
    }
}
