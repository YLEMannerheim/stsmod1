package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.RegenPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class PasteurizeCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "PasteurizeCard",
            2,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.RARE,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    public PasteurizeCard() {
        super(cardInfo);
        setExhaust(true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new RemoveDebuffsAction(p));
        addToBot(new RemoveSpecificPowerAction(p, p, "Shackled"));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(1);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new PasteurizeCard();
    }
}