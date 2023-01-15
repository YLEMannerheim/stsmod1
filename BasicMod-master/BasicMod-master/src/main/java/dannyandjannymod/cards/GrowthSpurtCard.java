package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.DiscountDairyAction;
import dannyandjannymod.GrowthSpurtAction;
import dannyandjannymod.powers.ImmuneSystemPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class GrowthSpurtCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GrowthSpurtCard",
            -1,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.COMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 0;
    public static final int UPG_MAGIC = 1;


    public GrowthSpurtCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GrowthSpurtAction(p, this.freeToPlayOnce, this.energyOnUse + this.magicNumber));
        //this.addToBot(new ApplyPowerAction(p, p, new ImmuneSystemPower(p, 1), 1));

    }



    @Override
    public AbstractCard makeCopy() { //Optional
        return new GrowthSpurtCard();
    }
}