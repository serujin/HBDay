package com.seruji.hb.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Assets {
	public static Sprite introductionBg;
	public static Sprite mainMenuBg;
	public static Sprite movingToMadridBg;
	public static Sprite universityBg;
	public static Sprite halloweenBg;
	public static Sprite cuencaBg;
	public static Sprite quarantineBg;
	public static Sprite drivingLessonsBg;
	public static Sprite summerBg;
	public static Sprite[] introductionSprites;
	public static Sprite[] mainMenuSprites;
	public static Sprite[] movingToMadridSprites;
	public static Sprite[] universitySprites;
	public static Sprite[] halloweenSprites;
	public static Sprite[] cuencaSprites;
	public static Sprite[] quarantineSprites;
	public static Sprite[] drivingLessonsSprites;
	public static Sprite[] summerSprites;
	public static Sprite[] variousSprites;
	public static BitmapFont font;
	public static BitmapFont uniFont;
	
	public static void load() {
		font = initFont(100, "MenuFont");
		uniFont = initFont(40, "UniFont");
		initBackgrounds();
		introductionSprites = initIntroductionSprites();
		mainMenuSprites = initMainMenuGraphics();
		movingToMadridSprites = initMovingToMadridGraphics();
		universitySprites = initUniversityGraphics();
		halloweenSprites = initHalloweenGraphics();
		cuencaSprites = initCuencaGraphics();
		quarantineSprites = initQuarantineGraphics();
		drivingLessonsSprites = initDrivingLessonsGraphics();
		summerSprites = initSummerGraphics();
		variousSprites = initVariousGraphics();
	}
	
	private static void initBackgrounds() {
		introductionBg = null;
		mainMenuBg = initSprite(loadTexture("mainmenu", "MainMenuBG", "png"));
		movingToMadridBg = initSprite(loadTexture("movingtomadrid", "RoomBG", "png"));
		universityBg = initSprite(loadTexture("university", "UniversityBG", "png"));
		halloweenBg = initSprite(loadTexture("halloween", "HalloweenBG", "png"));
		cuencaBg = initSprite(loadTexture("cuenca", "CuencaBg", "png"));
		quarantineBg = null;
		drivingLessonsBg = null;
		summerBg = null;
	}

	private static Sprite[] initIntroductionSprites() {
		return new Sprite[] {
				
		};
	}
	
	private static Sprite[] initMainMenuGraphics() {
		Texture mainMenu = loadTexture("mainmenu", "MainMenu", "png");
		TextureRegion blue1 = extract(mainMenu, 0, 0, 1, 1);
		TextureRegion blue2 = extract(mainMenu, 1, 0, 1, 1);
		TextureRegion blue3 = extract(mainMenu, 2, 0, 1, 1);
		TextureRegion blue4 = extract(mainMenu, 3, 0, 1, 1);
		TextureRegion blue5 = extract(mainMenu, 4, 0, 1, 1);
		TextureRegion arrowL = extract(mainMenu, 0, 1, 1, 1);
		TextureRegion arrowR = extract(mainMenu, 0, 1, 1, 1);
		return new Sprite[] {
			initSprite(blue1),
			initSprite(blue2),
			initSprite(blue3),
			initSprite(blue4),
			initSprite(blue5),
			initSprite(arrowL, true, true),
			initSprite(arrowR)
		};
	}
	
	private static Sprite[] initMovingToMadridGraphics() {
		Texture movingToMadrid = loadTexture("movingtomadrid", "Room", "png");
		TextureRegion[] suitcase = new TextureRegion[] {
			extract(movingToMadrid, 0, 0, 1, 1),
			extract(movingToMadrid, 1, 0, 1, 1),
			extract(movingToMadrid, 2, 0, 1, 1),
			extract(movingToMadrid, 0, 1, 1, 1),
			extract(movingToMadrid, 1, 1, 1, 1),
			extract(movingToMadrid, 2, 1, 1, 1),
			extract(movingToMadrid, 0, 2, 1, 1),
			extract(movingToMadrid, 1, 2, 1, 1),
			extract(movingToMadrid, 2, 2, 1, 1),
			extract(movingToMadrid, 3, 1, 1, 1)
		};
		TextureRegion trainer = 	extract(movingToMadrid, 0, 7, 2, 1);
		TextureRegion underwear =	extract(movingToMadrid, 2, 7, 2, 1);
		TextureRegion sock =		extract(movingToMadrid, 2, 8, 1, 1);
		TextureRegion trousers = 	extract(movingToMadrid, 2, 9, 2, 1);
		TextureRegion hat = 		extract(movingToMadrid, 3, 8, 1, 1);
		return new Sprite[] {
			initSprite(suitcase[0]),
			initSprite(suitcase[1]),
			initSprite(suitcase[2]),
			initSprite(suitcase[3]),
			initSprite(suitcase[4]),
			initSprite(suitcase[5]),
			initSprite(suitcase[6]),
			initSprite(suitcase[7]),
			initSprite(suitcase[8]),
			initSprite(suitcase[9]), 
			initSprite(trainer),
			initSprite(underwear),
			initSprite(sock),
			initSprite(trousers),
			initSprite(hat)
		};
	}
	
	private static Sprite[] initUniversityGraphics() {
		Texture university = loadTexture("university", "University", "png");
		TextureRegion lorena =   extract(university, 0, 0, 1, 2);
		TextureRegion guy1 =     extract(university, 0, 2, 1, 2);
		TextureRegion guy2 =     extract(university, 1, 2, 1, 2);
		TextureRegion bus =      extract(university, 1, 0, 4, 2);
		TextureRegion busStop =  extract(university, 6, 0, 4, 2);
		TextureRegion road =     extract(university, 2, 2, 1, 3);
		TextureRegion roadMark = extract(university, 5, 2, 1, 1);
		TextureRegion stop =     extract(university, 6, 2, 1, 1);
		TextureRegion wall =     extract(university, 5, 0, 1, 1);
		TextureRegion sky = 	 extract(university, 5, 1, 1, 1);
		return new Sprite[] {
			initSprite(lorena),
			initSprite(guy1),
			initSprite(guy2, true, true),
			initSprite(bus, true, true),
			initSprite(busStop),
			initSprite(road),
			initSprite(roadMark),
			initSprite(stop),
			initSprite(wall),
			initSprite(sky)
		};
	}
	
	private static Sprite[] initHalloweenGraphics() {
		Texture halloween = loadTexture("halloween", "Halloween", "png");
		TextureRegion lorenaNaked = extract(halloween, 0, 0, 1, 2);
		TextureRegion lorenaBody =  extract(halloween, 2, 0, 1, 2);
		TextureRegion lorenaFace =  extract(halloween, 4, 0, 1, 2);
		TextureRegion lorenaAcc =   extract(halloween, 6, 0, 1, 2);
		TextureRegion lorenaLegs =  extract(halloween, 8, 0, 1, 2);
		TextureRegion lorenaShoes = extract(halloween, 2, 2, 1, 2);
		TextureRegion sergioNaked = extract(halloween, 1, 0, 1, 2);
		TextureRegion sergioBody =  extract(halloween, 3, 0, 1, 2);
		TextureRegion sergioFace =  extract(halloween, 5, 0, 1, 2);
		TextureRegion sergioAcc =   extract(halloween, 7, 0, 1, 2);
		TextureRegion sergioLegs =  extract(halloween, 9, 0, 1, 2);
		TextureRegion sergioShoes = extract(halloween, 3, 2, 1, 2);
		TextureRegion cake1 =       extract(halloween, 0, 2, 2, 2);
		TextureRegion cake2 =       extract(halloween, 0, 4, 2, 2);
		TextureRegion cake3 =       extract(halloween, 0, 6, 2, 2);
		TextureRegion button =      extract(halloween, 4, 2, 2, 1);
		return new Sprite[] {
			initSprite(lorenaNaked),
			initSprite(lorenaFace),
			initSprite(lorenaBody),
			initSprite(lorenaAcc),
			initSprite(lorenaLegs),
			initSprite(lorenaShoes),
			initSprite(sergioNaked),
			initSprite(sergioFace),
			initSprite(sergioBody),
			initSprite(sergioAcc),
			initSprite(sergioLegs),
			initSprite(sergioShoes),
			initSprite(cake1),
			initSprite(cake2),
			initSprite(cake3),
			initSprite(button),
			initSprite(loadTexture("halloween", "HalloweenHouse", "png"))
		};
	}

	private static Sprite[] initCuencaGraphics() {
		Texture cuenca = loadTexture("cuenca", "Cuenca", "png");
		TextureRegion lorenaBus = extract(cuenca, 0, 0, 1, 2);
		TextureRegion sergioBus = extract(cuenca, 1, 0, 1, 2);
		TextureRegion lorenaCoa = extract(cuenca, 2, 0, 1, 2);
		TextureRegion sergioCoa = extract(cuenca, 3, 0, 1, 2);
		TextureRegion suitcase  = extract(cuenca, 4, 0, 2, 2);
		return new Sprite[] {
			initSprite(lorenaBus, true, true),
			initSprite(sergioBus, true, true),
			initSprite(lorenaCoa, true, true),
			initSprite(sergioCoa, true, true),
			initSprite(suitcase, true, true),
			initSprite(loadTexture("cuenca", "Grotte", "png")),
			initSprite(loadTexture("cuenca", "TorreDeMangana", "png"))
		};
	}
	
	private static Sprite[] initQuarantineGraphics() {
		return new Sprite[] {
				
		};
	}
	
	private static Sprite[] initDrivingLessonsGraphics() {
		return new Sprite[] {
				
		};
	}
	
	private static Sprite[] initSummerGraphics() {
		return new Sprite[] {
				
		};
	}
	
	private static Sprite[] initVariousGraphics() {
		Texture back = loadTexture("various", "Back", "png");
		return new Sprite[] {
			initSprite(back)
		};
	}
	
	private static Texture loadTexture(String parentFolder, String name, String format) {
		Texture temp = new Texture(Gdx.files.internal(parentFolder+"/"+name+"."+format));
		temp.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		return temp;
	}
	
	private static TextureRegion extract(Texture texture, int x, int y, int width, int height) {
		return new TextureRegion(texture, x * 16, y * 16, width * 16, height * 16);
	}
	
	private static Sprite initSprite(TextureRegion texture) {
		Sprite temp = new Sprite(texture);
		temp.flip(false, true);
		return temp;
	}
	
	private static Sprite initSprite(TextureRegion texture, boolean flipX, boolean flipY) {
		Sprite temp = new Sprite(texture);
		temp.flip(flipX, flipY);
		return temp;
	}
	
	private static Sprite initSprite(Texture texture) {
		Sprite temp = new Sprite(texture);
		temp.flip(false, true);
		return temp;
	}
	
	private static BitmapFont initFont(int size, String name) {
		FreeTypeFontGenerator generator;
		FreeTypeFontParameter parameter;
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/"+name+".ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = size;
		parameter.minFilter = TextureFilter.Linear;
		parameter.magFilter = TextureFilter.Linear;
		parameter.flip = true;
		return generator.generateFont(parameter);
	}
}
