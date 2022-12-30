package dannyandjannymod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.defect.IncreaseMiscAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
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
            CardColor.RED);

    public static final String ID = makeID(cardInfo.baseId);

    private static final int UPG_DAMAGE = 5;
    private static final int DAMAGE = 25;
    private static final int MAGIC = 1;

    public DentedBucketCard() {
        super(cardInfo);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(MAGIC);
        this.tags.add(CustomTags.BUCKET);
        this.misc = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SMASH));
        addToBot(new DentedBucketAction(this.uuid, this.magicNumber));
    }

    public void applyPowers() {
        this.baseDamage = Math.max(0, DAMAGE - this.misc);
        super.applyPowers();
        this.initializeDescription();
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new DentedBucketCard();
    }
}