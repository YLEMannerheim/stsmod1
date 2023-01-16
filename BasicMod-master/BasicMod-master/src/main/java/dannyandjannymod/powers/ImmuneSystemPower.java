package dannyandjannymod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import dannyandjannymod.CardWithTagGenerationAction;
import dannyandjannymod.CustomTags;
import dannyandjannymod.util.TextureLoader;

public class ImmuneSystemPower extends AbstractPower {
    public static final String POWER_ID = "ImmuneSystemPower";
    public static final String NAME;


    public ImmuneSystemPower(AbstractCreature owner, int cardAmount) {
        this.name = NAME;
        this.ID = "ImmuneSystemPower";
        this.owner = owner;
        this.amount = cardAmount;
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

    @Override
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        AbstractPlayer p = AbstractDungeon.player;
        if (source == p && power.type == PowerType.DEBUFF) {
            this.addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, this.amount), this.amount));
        }
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        this.description = String.format(DESCRIPTIONS[0], this.amount);
    }

    static {
        //powerStrings = CardCrawlGame.languagePack.getPowerStrings("Magnetism");
        //NAME = powerStrings.NAME;
        NAME = "Immune System";
        //SINGULAR_DESCRIPTION = powerStrings.DESCRIPTIONS[0];
        DESCRIPTIONS = new String[]{"Whenever you apply a #yDebuff to yourself, gain #b%d [E] next turn."};

    }
}