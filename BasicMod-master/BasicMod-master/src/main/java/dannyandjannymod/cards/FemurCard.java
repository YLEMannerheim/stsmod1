package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import dannyandjannymod.BottleHolderAction;
import dannyandjannymod.FemurAction;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class FemurCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FemurCard",
            1,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 1;
    public static final int UPG_MAGIC = 1;

    public FemurCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new CalciumPower(p, this.magicNumber), this.magicNumber));
        /*
        if (p.getPower("CalciumPower") != null) {

            int calcAmt = p.getPower("CalciumPower").amount;
            this.addToBot(new DrawCardAction(p, calcAmt));
        }
        */
        this.addToBot(new FemurAction(p, 99));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new FemurCard();
    }
}