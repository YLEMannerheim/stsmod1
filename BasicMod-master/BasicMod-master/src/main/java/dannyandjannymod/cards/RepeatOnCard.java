package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.unique.RepeatOnAction;
import com.megacrit.cardcrawl.actions.unique.SkewerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
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
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int DAMAGE = 5;

    public RepeatOnCard() {
        super(cardInfo);
        setDamage(DAMAGE);
        setMagic(0, 1);
    }

    public void upgrade() {
        ++this.timesUpgraded;
        this.upgraded = true;
        this.name = cardStrings.NAME + "+" + this.timesUpgraded;
        this.initializeTitle();
        this.upgradeMagicNumber(1);
        this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        this.initializeDescription();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new RepeatOnAction(p, m, this.damage, DamageInfo.DamageType.NORMAL, this.freeToPlayOnce, this.energyOnUse + this.timesUpgraded));
    }

    public boolean canUpgrade() {
        return true;
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RepeatOnCard();
    }
}