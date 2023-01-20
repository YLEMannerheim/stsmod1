package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class CappuccinoCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "CappuccinoCard",
            2,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 2;
    public static final int UPG_MAGIC = 1;

    public CappuccinoCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(p, p, new CalciumPower(p, this.magicNumber), this.magicNumber));
        this.addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, this.magicNumber), this.magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new CappuccinoCard();
    }
}