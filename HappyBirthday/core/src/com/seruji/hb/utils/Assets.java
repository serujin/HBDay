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
	public static Sprite endGiftBg;
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
	public static Sprite[] photos;
	public static BitmapFont font;
	public static BitmapFont uniFont;
	
	public static void load() {
		font = initFont(100, "MenuFont");
		uniFont = initFont(40, "UniFont");
		initBackgrounds();
		mainMenuSprites = initMainMenuGraphics();
		movingToMadridSprites = initMovingToMadridGraphics();
		universitySprites = initUniversityGraphics();
		halloweenSprites = initHalloweenGraphics();
		cuencaSprites = initCuencaGraphics();
		quarantineSprites = initQuarantineGraphics();
		drivingLessonsSprites = initDrivingLessonsGraphics();
		summerSprites = initSummerGraphics();
		variousSprites = initVariousGraphics();
		loadPhotos();
	}
	
	private static void loadPhotos() {
		photos = new Sprite[] {
			loadPhoto("Agosto_1"),
			loadPhoto("Agosto_2"),
			loadPhoto("Septiembre_1"),
			loadPhoto("Septiembre_2"),
			loadPhoto("Septiembre_3"),
			loadPhoto("Octubre_1"),
			loadPhoto("Octubre_2"),
			loadPhoto("Noviembre_1"),
			loadPhoto("Noviembre_2"),
			loadPhoto("Diciembre_1"),
			loadPhoto("Diciembre_2"),
			loadPhoto("Enero_1"),
			loadPhoto("Enero_2"),
			loadPhoto("Febrero_1"),
			loadPhoto("Febrero_2"),
			loadPhoto("Marzo_1"),
			loadPhoto("Marzo_2"),
			loadPhoto("Abril_1"),
			loadPhoto("Abril_2"),
			loadPhoto("Mayo_1"),
			loadPhoto("Mayo_2"),	
			loadPhoto("Junio_1"),	
			loadPhoto("Junio_2"),
			loadPhoto("Extra_1"),
			loadPhoto("Extra_2"),
			loadPhoto("Extra_3"),
			loadPhoto("Extra_4"),
			loadPhoto("Extra_5")
		};
	}
	
	private static void initBackgrounds() {
		introductionBg = initSprite(loadTexture("introduction", "IntroBg"));
		mainMenuBg = initSprite(loadTexture("mainmenu", "MainMenuBG"));
		movingToMadridBg = initSprite(loadTexture("movingtomadrid", "RoomBG"));
		universityBg = initSprite(loadTexture("university", "UniversityBG"));
		halloweenBg = initSprite(loadTexture("halloween", "HalloweenBG"));
		cuencaBg = initSprite(loadTexture("cuenca", "CuencaBg"));
		quarantineBg = initSprite(loadTexture("quarantine", "SanseRoom"));
		drivingLessonsBg = initSprite(loadTexture("drivingLessons", "DrivingBg1"));
		summerBg = initSprite(loadTexture("summer", "SummerBg"));
		endGiftBg = introductionBg;
	}
	
	private static Sprite[] initMainMenuGraphics() {
		Texture mainMenu = loadTexture("mainmenu", "MainMenu");
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
		Texture movingToMadrid = loadTexture("movingtomadrid", "Room");
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
		Texture university = loadTexture("university", "University");
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
		Texture halloween = loadTexture("halloween", "Halloween");
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
			initSprite(loadTexture("halloween", "HalloweenHouse"))
		};
	}

	private static Sprite[] initCuencaGraphics() {
		Texture cuenca = loadTexture("cuenca", "Cuenca");
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
			initSprite(loadTexture("cuenca", "Grotte")),
			initSprite(loadTexture("cuenca", "TorreDeMangana"))
		};
	}
	
	private static Sprite[] initQuarantineGraphics() {
		Texture quarantine = loadTexture("quarantine", "Quarantine");
		TextureRegion lorenaPijama = extract(quarantine, 0, 0, 1, 2);
		TextureRegion lorenaStreet = extract(quarantine, 0, 3, 1, 2);
		TextureRegion sergioPijama = extract(quarantine, 1, 0, 1, 2);
		TextureRegion sergioStreet = extract(quarantine, 1, 3, 1, 2);
		TextureRegion rex          = extract(quarantine, 3, 2, 1, 1);
		TextureRegion machineOff   = extract(quarantine, 2, 0, 1, 2);
		TextureRegion machineOn    = extract(quarantine, 3, 0, 1, 2);
		TextureRegion sergioFace   = extract(quarantine, 0, 2, 1, 1);
		TextureRegion hairPixel    = extract(quarantine, 2, 2, 1, 1);
		TextureRegion blanket      = extract(quarantine, 4, 0, 5, 3);
		return new Sprite[] {
			initSprite(lorenaPijama),
			initSprite(lorenaStreet),
			initSprite(sergioPijama),
			initSprite(sergioStreet),
			initSprite(rex),
			initSprite(machineOff),
			initSprite(machineOn),
			initSprite(sergioFace),
			initSprite(hairPixel),
			initSprite(blanket),
			initSprite(loadTexture("quarantine", "SanseStreet"))
		};
	}
	
	private static Sprite[] initDrivingLessonsGraphics() {
		Texture drivingLessons = loadTexture("drivingLessons", "Driving");
		TextureRegion car =      extract(drivingLessons, 0, 0, 6, 5);
		TextureRegion roadMark = extract(drivingLessons, 6, 0, 1, 1);
		TextureRegion woman =    extract(drivingLessons, 7, 0, 2, 4);
		TextureRegion kid1 =     extract(drivingLessons, 6, 4, 1, 3);
		TextureRegion kid2 =     extract(drivingLessons, 7, 4, 1, 3);
		TextureRegion kid3 =     extract(drivingLessons, 8, 4, 1, 3);
		TextureRegion lorena =   extract(drivingLessons, 0, 5, 1, 2);
 		return new Sprite[] {
			initSprite(loadTexture("drivingLessons", "DrivingBg2")),
			initSprite(loadTexture("drivingLessons", "DrivingBg3")),
			initSprite(car),
			initSprite(roadMark),
			initSprite(woman),
			initSprite(kid1),
			initSprite(kid2),
			initSprite(kid3),
			initSprite(lorena)
		};
	}
	
	private static Sprite[] initSummerGraphics() {
		Texture summer = loadTexture("summer", "Summer");
		TextureRegion car1 =   extract(summer, 0, 0, 1, 1);
		TextureRegion car2 =   extract(summer, 1, 0, 1, 1);
		TextureRegion car3 =   extract(summer, 2, 0, 1, 1);
		TextureRegion car4 =   extract(summer, 0, 1, 1, 1);
		TextureRegion car5 =   extract(summer, 1, 1, 1, 1);
		TextureRegion car6 =   extract(summer, 2, 1, 1, 1);
		TextureRegion lorena = extract(summer, 3, 0, 1, 2);
		return new Sprite[] {
			initSprite(loadTexture("summer", "SummerBg2")),
			initSprite(loadTexture("summer", "Valldemossa")),
			initSprite(car1),
			initSprite(car2),
			initSprite(car3),
			initSprite(car4),
			initSprite(car5),
			initSprite(car6),
			initSprite(lorena)
		};
	}
	
	private static Sprite loadPhoto(String name) {
		Texture temp = new Texture(Gdx.files.internal("photos/"+name+".jpg"));
		temp.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		Sprite tempS = new Sprite(temp);
		tempS.flip(false, true);
		return tempS;
	}
	
	private static Sprite[] initVariousGraphics() {
		Texture back = loadTexture("various", "Back");
		return new Sprite[] {
			initSprite(back)
		};
	}
	
	private static Texture loadTexture(String parentFolder, String name) {
		Texture temp = new Texture(Gdx.files.internal(parentFolder+"/"+name+".png"));
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
