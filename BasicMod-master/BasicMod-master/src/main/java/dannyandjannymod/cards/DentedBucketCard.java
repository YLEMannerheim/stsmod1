package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.defect.IncreaseMiscAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import dannyandjannymod.AbstractCardEnum;
import dannyandjannymod.CustomTags;
import dannyandjannymod.DentedBucketAction;
import dannyandjannymod.util.CardInfo;

import static dannyandjannymod.BasicMod.makeID;

public class DentedBucketCard extends BaseCard {
    private final static CardInfo cardInfo = new CardInfo(
            "DentedBucketCard",
            1,
            CardType.ATTACK,
            CardTarget.ENEMY,
            CardRarity.RARE,
            AbstractCardEnum.MILKMAN_WHITE);

    public static final String ID = makeID(cardInfo.baseId);

    public static final int UPG_DAMAGE = 5;
    private static final int DAMAGE = 25;
    private static final int MAGIC = 1;

    public DentedBucketCard() {
        super(cardInfo);
        this.misc = DAMAGE;
        setMagic(MAGIC);
        setDamage(this.misc, UPG_DAMAGE);
        this.tags.add(CustomTags.BUCKET);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToTop(new DentedBucketAction(this.uuid, -this.magicNumber));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SMASH));
    }

    public void applyPowers() {
        this.baseBlock = this.misc;
        super.applyPowers();
        this.initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DentedBucketCard();
    }
}