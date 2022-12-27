package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class CalciumDeficiencyCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CalciumDeficiencyCard",
            -2,
            CardType.CURSE,
            CardTarget.NONE,
            CardRarity.CURSE,
            CardColor.CURSE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 3;

    public CalciumDeficiencyCard() {
        super(cardInfo);
        setMagic(MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (this.dontTriggerOnUseCard) {
            this.addToBot(new ApplyPowerAction(p, p, new CalciumPower(p, -this.magicNumber), -this.magicNumber));
        }
    }

    public void triggerOnEndOfTurnForPlayingCard() {
        this.dontTriggerOnUseCard = true;
        AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(this, true));
    }

    public void upgrade() {
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new CalciumDeficiencyCard();
    }
}