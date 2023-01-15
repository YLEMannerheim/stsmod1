package dannyandjannymod;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.ThornsPower;
import dannyandjannymod.relics.BreakfastRelic;

public class BigBreakfastAction extends AbstractGameAction {

    public BigBreakfastAction() {
        this.actionType = ActionType.WAIT;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        if (p.hasRelic(new BreakfastRelic().relicId))
            p.loseRelic(new BreakfastRelic().relicId);

        this.isDone = true;
    }
}