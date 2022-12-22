package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.unique.SkewerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class RepeatOnCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "RepeatOnCard",
            -1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.UNCOMMON,
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 5;
    private static final int MAGIC = 0;
    private static final int UPG_MAGIC = 1;

    public RepeatOnCard() {
        super(cardInfo);
        setDamage(DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
    }

    public void upgrade() {
        this.upgradeDamage(4 + this.timesUpgraded);
        ++this.timesUpgraded;
        this.upgraded = true;
        this.name = cardStrings.NAME + "+" + this.timesUpgraded;
        this.initializeTitle();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SkewerAction(p, m, this.damage, DamageInfo.DamageType.NORMAL, true, this.energyOnUse + this.magicNumber));
    }

    public boolean canUpgrade() {
        return true;
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RepeatOnCard();
    }
}