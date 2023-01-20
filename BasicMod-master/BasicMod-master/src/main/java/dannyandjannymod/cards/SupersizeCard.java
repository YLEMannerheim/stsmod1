package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.powers.CattleFarmPower;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class SupersizeCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "SupersizeCard",
            1,
            CardType.POWER,
            CardTarget.NONE,
            CardRarity.UNCOMMON,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);
    public static final int MAGIC = 1;
    public static final int UPG_MAGIC = 1;


    public SupersizeCard() {
        super(cardInfo);
        setMagic(MAGIC, UPG_MAGIC);
        setEthereal(true);
        this.tags.add(CardTags.HEALING);

    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        p.increaseMaxHp(this.magicNumber, true);
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SupersizeCard();
    }
}