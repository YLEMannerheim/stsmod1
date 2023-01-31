package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.unique.ArmamentsAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import com.megacrit.cardcrawl.vfx.combat.LightningEffect;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

public class LactoseIntolerancePower extends AbstractPower {
    public static final String POWER_ID = "LactoseIntolerancePower";
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public LactoseIntolerancePower(AbstractCreature owner, int stackAmount) {
        this.name = NAME;
        this.ID = "LactoseIntolerancePower";
        this.owner = owner;
        this.amount = stackAmount;
        this.type = PowerType.DEBUFF;
        this.updateDescription();
        this.loadRegion("confusion");

        String unPrefixed = ID;
        Texture normalTexture = TextureLoader.getPowerTexture(unPrefixed);
        Texture hiDefImage = TextureLoader.getHiDefPowerTexture(unPrefixed);
        if (hiDefImage != null)
        {
            region128 = new TextureAtlas.AtlasRegion(hiDefImage, 0, 0, hiDefImage.getWidth(), hiDefImage.getHeight());
            if (normalTexture != null)
                region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }
        else if (normalTexture != null)
        {
            this.img = normalTexture;
            region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }
    }

    /*

    @Override
    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        if (card.hasTag(CustomTags.MILK)) {
            this.flash();
            AbstractPlayer p = AbstractDungeon.player;
            addToBot(new ApplyPowerAction(owner, p, new PoisonPower(owner, p, this.amount), this.amount, true));
        }
    }
    */

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.type == DamageInfo.DamageType.NORMAL) {
            this.flash();
            this.addToTop(new LoseHPAction(this.owner, (AbstractCreature) null, this.amount, AbstractGameAction.AttackEffect.LIGHTNING));
            //this.addToTop(new VFXAction(new LightningEffect(this.owner.drawX, this.owner.drawY), 0.1f));
            //this.addToTop(new SFXAction("ORB_LIGHTNING_EVOKE"));
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.owner.drawX, this.owner.drawY, AbstractGameAction.AttackEffect.POISON));
        }

        return damageAmount;
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    static {
        //powerStrings = CardCrawlGame.languagePack.getPowerStrings("Magnetism");
        //NAME = powerStrings.NAME;
        NAME = "Lactose Intolerance";
        //SINGULAR_DESCRIPTION = powerStrings.DESCRIPTIONS[0];
        DESCRIPTIONS = new String[] {"Whenever you play a #yMilk card, loses #b", " health."} ;
    }
}