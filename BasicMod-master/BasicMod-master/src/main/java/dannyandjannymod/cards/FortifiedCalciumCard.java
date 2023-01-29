package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.CalciumPower;
import dannyandjannymod.powers.FortifiedCalciumPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class FortifiedCalciumCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "FortifiedCalciumCard",
            1,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 3;

    public FortifiedCalciumCard() {
        super(cardInfo);
        setMagic(MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new FortifiedCalciumPower(p), 1));
        if (this.upgraded)
            addToBot(new ApplyPowerAction(p, p, new CalciumPower(p, magicNumber), magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new FortifiedCalciumCard();
    }
}