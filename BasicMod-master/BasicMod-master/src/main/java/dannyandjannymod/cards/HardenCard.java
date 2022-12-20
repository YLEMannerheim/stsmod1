package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class HardenCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "HardenCard",
            3,
            CardType.SKILL,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int MAGIC_NUM = 1;
    private static final int BLOCK = 10;

    public HardenCard() {
        super(cardInfo);
        setMagic(MAGIC_NUM);
        setBlock(BLOCK);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, block));
        this.addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, this.magicNumber), this.magicNumber));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBaseCost(2);
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new HardenCard();
    }
}