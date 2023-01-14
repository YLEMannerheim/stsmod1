package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.ThornsPower;

public class GlassBankAction extends AbstractGameAction {
    private int divideAmount;

    public GlassBankAction(int divideAmountNum) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.divideAmount = divideAmountNum;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            AbstractPlayer p = AbstractDungeon.player;
            int thornsAmt = p.drawPile.size() / this.divideAmount;
            if (thornsAmt > 0)
                this.addToBot(new ApplyPowerAction(p, p, new ThornsPower(p, thornsAmt), thornsAmt));
        }

        this.tickDuration();
    }
}