package dannyandjannymod.powers;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import dannyandjannymod.CustomTags;


public class PositivePower extends AbstractPower {
    public static final String POWER_ID = "PositivePower";
    public static final String NAME;

    public PositivePower(AbstractCreature owner, int drawAmt) {
        this.name = NAME;
        this.ID = "PositivePower";
        this.owner = owner;
        this.amount = drawAmt;
        this.updateDescription();
        this.loadRegion("evolve");
    }


    public void onCardDraw(AbstractCard card) {
        if ((card.tags.contains(CustomTags.AUTO) || card.cost == -2) && !this.owner.hasPower("No Draw")) {
            this.flash();
            this.addToBot(new DrawCardAction(this.owner, this.amount));
        }
    }

    public void updateDescription() {
        if (this.amount > 1) {
            this.description = "Whenever you draw an Unplayable card, draw " + this.amount + " cards.";
        } else {
            this.description = "Whenever you draw an Unplayable card, draw a card.";
        }
    }

    static {
        NAME = "Positivity";
    }
}
