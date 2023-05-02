package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.MetallicizePower;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.GrowthSpurtAction;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class GrowthSpurtCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "GrowthSpurtCard",
            -1,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 1;


    public GrowthSpurtCard() {
        super(cardInfo);
        setMagic(MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int amt = this.energyOnUse * this.magicNumber;
        this.addToBot(new GrowthSpurtAction(p, this.freeToPlayOnce, amt, upgraded));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new GrowthSpurtCard();
    }
}