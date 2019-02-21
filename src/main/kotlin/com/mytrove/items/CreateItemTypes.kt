// Copyright (c) 2017. Trove Technologies, Inc.

package com.mytrove.items

import java.util.*

/**
 * Creates the ItemTypes in the database.
 */
fun main(args: Array<String>) {

  CreateItemTypes().create()
}

class CreateItemTypes{

  fun create() {

    val familiesToAdd = mutableListOf<FamilyToAdd>()

    fun family(
      uuid: String,
      singular: String,
      plural: String,
      image: String,
      alternateNames: List<String> = emptyList(),
      nameGeneric: String = plural,
      category: ItemFamilyCategory
    ): FamilyToAdd =
      FamilyToAdd(
        uuid.toUUID(),
        nameGeneric,
        singular,
        plural,
        alternateNames,
        image,
        category
      )
        .also { familiesToAdd.add(it) }

    fun ItemFamily.BuiltIn.toFamilyToAdd(): FamilyToAdd = family(
      uuid = uuid.toString(),
      nameGeneric = strings[0].name.generic,
      plural = strings[0].name.plural,
      singular = strings[0].name.singular,
      alternateNames = strings[0].alternateSearchStrings,
      image = imageUrl.substringAfter("https://trove.imgix.net/assets/inventory/").substringBefore(".png"),
      category = category
    )


    fun ItemType.BuiltIn.toItemToAdd(): ItemToAdd {
      return ItemToAdd(
        uuid = this.uuid,
        category = this.category,
        nameGeneric = this.strings[0].name.generic,
        namePlural = this.strings[0].name.plural,
        nameSingular = this.strings[0].name.singular,
        cft = this.cubicFeetEstimate,
        alternateNames = this.strings[0].alternateSearchStrings,
        imageName = this.imageUrl.substringAfter("https://trove.imgix.net/assets/inventory/").substringBefore(
          ".png"
        ),
        families = this.families.map { uuid -> familiesToAdd.first { it.uuid == uuid } },
        isPotentiallyOversized = isPotentiallyOversize
      )
    }

    // ===== Item Family's =====

    val residences = ItemFamily.BuiltIn.RESIDENCE.toFamilyToAdd()
    val chairs = ItemFamily.BuiltIn.CHAIRS.toFamilyToAdd()
    val diningRoomFamily = ItemFamily.BuiltIn.DINING_ROOM.toFamilyToAdd()

    val sofas = family(
      uuid = "8ED8522E-4F03-454B-884B-01B31527FFD1",
      singular = "Sofa",
      plural = "Sofas",
      image = "sofa-2",
      alternateNames = listOf("Couches"),
      category = ItemFamilyCategory.USE
    )
    val boxes = family(
      uuid = "B54B3672-0B16-4647-B41E-1257CAAA4EB4",
      singular = "Box",
      plural = "Boxes",
      image = "box",
      category = ItemFamilyCategory.USE
    )
    val bins = family(
      uuid = "D3264F42-94A8-4E1B-B8E6-54BF17A7F38A",
      singular = "Bin",
      plural = "Bins",
      image = "plastic-bin",
      category = ItemFamilyCategory.USE
    )
    val tables = family(
      uuid = "31EEA757-EAE9-4F01-833D-BA303C2F7E96",
      singular = "Table",
      plural = "Tables",
      image = "dining-table",
      category = ItemFamilyCategory.USE
    )
    val mattresses = family(
      uuid = "8A23C4D9-0390-4049-B0FD-B3F1447B699D",
      singular = "Mattress",
      plural = "Mattresses",
      image = "mattress",
      category = ItemFamilyCategory.USE
    )
    val bedFrames = family(
      uuid = "19ACAABC-AEFE-4EF8-9510-3B20FA917B5B",
      singular = "Bed Frame",
      plural = "Bed Frames",
      image = "bed-frame",
      category = ItemFamilyCategory.USE
    )
    val boxSprings = family(
      uuid = "A636F5C6-B6A5-4725-85BF-E22E44E57370",
      singular = "Box Spring",
      plural = "Box Springs",
      image = "box-spring",
      category = ItemFamilyCategory.USE
    )
    val tvAndEntertainment = family(
      uuid = "4891AAD2-A83F-4AC0-B23C-994827CD9F2E",
      singular = "TV or Entertainment product",
      plural = "TV & Entertainment",
      image = "television",
      alternateNames = listOf("TVs"),
      category = ItemFamilyCategory.USE
    )
    val dressers = family(
      uuid = "73D3E032-F152-4E1E-9200-5C0ED6A40F54",
      singular = "Dresser",
      plural = "Dressers",
      image = "dresser",
      category = ItemFamilyCategory.USE
    )
    val drawers = family(
      uuid = "07C0106F-37BF-466F-BD44-8151FC655C3D",
      singular = "Drawer",
      plural = "Drawers",
      image = "2-piece-china-hutch",
      category = ItemFamilyCategory.USE
    )
    val art = family(
      uuid = "EA927F74-1B1D-4080-8185-ED13E6031307",
      singular = "Art",
      plural = "Art",
      image = "large-framed-picture",
      category = ItemFamilyCategory.USE
    )
    val shelves = family(
      uuid = "1DF6D702-993E-4E06-B053-B3AFF160BCD9",
      singular = "Shelf",
      plural = "Shelves",
      image = "shelves",
      category = ItemFamilyCategory.USE
    )
    val cabinets = family(
      uuid = "05FBD195-1D19-4592-BCBC-A0BCE558525B",
      singular = "Cabinet",
      plural = "Cabinets",
      image = "cabinet",
      category = ItemFamilyCategory.USE
    )
    val exerciseEquipment = family(
      uuid = "6307E01E-10D8-4FDE-BE35-22E5C8A0BF4D",
      singular = "Piece of Exercise Equipment",
      plural = "Exercise Equipment",
      alternateNames = listOf("Workout Equipment"),
      image = "exercise-equipment",
      category = ItemFamilyCategory.USE
    )
    val music = family(
      uuid = "D32E8822-287D-465B-93CD-DC3A245C5296",
      singular = "Music Item",
      plural = "Music Items",
      image = "drums",
      category = ItemFamilyCategory.USE
    )
    val sports = family(
      uuid = "72B0B261-B1EC-4D3F-A769-7804152C99EE",
      singular = "Sports",
      plural = "Sports",
      image = "sports-equipment",
      category = ItemFamilyCategory.USE
    )
    val camping = family(
      uuid = "FE7EA1A7-185A-4764-B913-FE9F05AE15EB",
      singular = "Camping Equipment",
      plural = "Camping Equipment",
      image = "tent",
      category = ItemFamilyCategory.USE
    )

    val bedroom = family(
      uuid = "F79AD362-8B19-401A-A431-F9CDB87B2B8F",
      singular = "Bedroom",
      plural = "Bedrooms",
      alternateNames = listOf("Master Bedroom"),
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val kidsRoom = family(
      uuid = "1E2FF26F-470F-4335-A51B-7CBE002AFE1B",
      singular = "Child's Room",
      plural = "Child's Rooms",
      alternateNames = listOf("Nursery", "Kid's Room"),
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val garage = family(
      uuid = "F87D2AA7-D1D5-40D5-8468-B7094EB24C37",
      singular = "Garage",
      plural = "Garages",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val kitchen = family(
      uuid = "9293F112-06F3-477F-A762-72252EA6F442",
      singular = "Kitchen",
      plural = "Kitchens",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val diningRoom = family(
      uuid = "B3BA364B-2080-4688-B96D-4994C95C28DB",
      singular = "Dining Room",
      plural = "Dining Rooms",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val office = family(
      uuid = "BEB952A3-C7D1-4799-AF4C-F9B32B599A16",
      singular = "Office",
      plural = "Offices",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val closet = family(
      uuid = "8A6734CE-D057-4C04-BF98-48A89FE54AA3",
      singular = "Closet",
      plural = "Closets",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val livingRoom = family(
      uuid = "256DFD21-BDBD-4D20-9CBC-8DC6C5C71464",
      singular = "Living Room",
      plural = "Living Rooms",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val attic = family(
      uuid = "ACC52255-3D7A-4C97-A6CB-01AA5617FED4",
      singular = "Attic",
      plural = "Attics",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val shed = family(
      uuid = "BE57DC36-C1B9-4BF4-B8B8-818CFE9BF231",
      singular = "Shed",
      plural = "Sheds",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val yard = family(
      uuid = "95769B92-0B5B-469C-ABF3-2A7174FB80C1",
      singular = "Yard",
      plural = "Yards",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val deck = family(
      uuid = "9FE51AE4-21DC-48F2-A48B-120A30586C55",
      singular = "Deck",
      plural = "Decks",
      alternateNames = listOf("Patio"),
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val laundryRoom = family(
      uuid = "00655884-B03D-46C4-AB21-4507F3CC04F6",
      singular = "Laundry Room",
      plural = "Laundry Rooms",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val entertainmentRoom = family(
      uuid = "1E77C192-DE47-4CB8-BA7C-BCAAACEF75C2",
      singular = "Entertainment Room",
      plural = "Entertainment Rooms",
      alternateNames = listOf("Home Theater", "TV Room", "Gaming Room"),
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val hallway = family(
      uuid = "B23C0A74-1130-46A7-98FD-061122E89999",
      singular = "Hallway",
      plural = "Hallways",
      image = "placeholder",
      alternateNames = listOf("Entryway"),
      category = ItemFamilyCategory.ROOM
    )
    val workshop = family(
      uuid = "CCBB9599-2EEE-4E62-BA1A-F5245EBEC226",
      singular = "Workshop",
      plural = "Workshops",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val bathroom = family(
      uuid = "8FB3311C-7A04-4EC9-A2B7-D0E3D2122493",
      singular = "Bathroom",
      plural = "Bathrooms",
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )
    val gym = family(
      uuid = "702BFCB3-DB08-485C-83A8-DFC6FE270A4C",
      singular = "Gym",
      plural = "Gyms",
      alternateNames = listOf("Workout Room"),
      image = "placeholder",
      category = ItemFamilyCategory.ROOM
    )

    /// ===== Item Types =====

    // residences
    val studio = ItemType.BuiltIn.STUDIO_RESIDENCE.toItemToAdd()
    val oneBedroom = ItemType.BuiltIn.ONE_BEDROOM_RESIDENCE.toItemToAdd()
    val twoBedroom = ItemType.BuiltIn.TWO_BEDROOM_RESIDENCE.toItemToAdd()
    val threeBedroom = ItemType.BuiltIn.THREE_BEDROOM_RESIDENCE.toItemToAdd()
    val fourBedroom = ItemType.BuiltIn.FOUR_BEDROOM_RESIDENCE.toItemToAdd()
    val fiveBedroom = ItemType.BuiltIn.FIVE_BEDROOM_RESIDENCE.toItemToAdd()

    // rooms
    val bathroomItem = ItemToAdd(
      uuid = UUID.fromString("EFA59A42-50CB-4326-B3C9-C1BD98099415"),
      category = ItemCategory.ROOM,
      nameSingular = "Bathroom",
      namePlural = "Bathrooms",
      cft = ItemTypeSizeConstants.bathroom,
      imageName = "placeholder"
    )
    val bedroomItem = ItemToAdd(
      uuid = UUID.fromString("964D6AE1-F1BC-4D3E-B369-6FEBC7D6E49E"),
      category = ItemCategory.ROOM,
      nameSingular = "Bedroom",
      namePlural = "Bedrooms",
      cft = ItemTypeSizeConstants.bedroom,
      imageName = "placeholder"
    )
    val closetItem = ItemToAdd(
      uuid = UUID.fromString("8871787D-E1AD-4219-BE5D-55212DA718CB"),
      category = ItemCategory.ROOM,
      nameSingular = "Closet",
      namePlural = "Closets",
      cft = ItemTypeSizeConstants.closet,
      imageName = "placeholder"
    )
    val diningRoomItem = ItemToAdd(
      uuid = UUID.fromString("163F9AE4-7EB4-41E8-BEFD-48A88945B6D5"),
      category = ItemCategory.ROOM,
      nameSingular = "Dining Room",
      namePlural = "Dining Rooms",
      cft = ItemTypeSizeConstants.diningRoom,
      imageName = "placeholder"
    )
    val garageItem = ItemToAdd(
      uuid = UUID.fromString("DDA3AA82-5923-47F4-A34E-DFA0C756BDCE"),
      category = ItemCategory.ROOM,
      nameSingular = "Garage",
      namePlural = "Garages",
      cft = ItemTypeSizeConstants.garage,
      imageName = "placeholder"
    )
    val kitchenItem = ItemToAdd(
      uuid = UUID.fromString("4D3C07C4-E441-454D-81CC-4804C1490867"),
      category = ItemCategory.ROOM,
      nameSingular = "Kitchen",
      namePlural = "Kitchens",
      cft = ItemTypeSizeConstants.kitchen,
      imageName = "placeholder"
    )
    val livingRoomItem = ItemToAdd(
      uuid = UUID.fromString("744C37E2-51B6-4E1E-8918-DE78C9E2D36B"),
      category = ItemCategory.ROOM,
      nameSingular = "Living Room",
      namePlural = "Living Rooms",
      alternateNames = listOf("TV Room", "Lounge"),
      cft = ItemTypeSizeConstants.livingRoom,
      imageName = "placeholder"
    )
    val officeItem = ItemToAdd(
      uuid = UUID.fromString("3E82C25C-8B1B-4E16-97D4-440758695EAF"),
      category = ItemCategory.ROOM,
      nameSingular = "Office",
      namePlural = "Offices",
      cft = ItemTypeSizeConstants.office,
      imageName = "placeholder"
    )

// items

    val airFilter = ItemToAdd(
      uuid = UUID.fromString("EE65724E-813C-46B9-990D-98B7109EDC55"),
      category = ItemCategory.OTHER,
      nameSingular = "Air Filter",
      namePlural = "Air Filters",
      cft = 8,
      imageName = "air-filter"
    )
    val acWindow = ItemToAdd(
      uuid = UUID.fromString("802C8FB8-6FCA-41BF-A1A6-CF380FCFC6E0"),
      category = ItemCategory.OTHER,
      nameSingular = "A/C, window",
      namePlural = "A/C's, window",
      cft = 13,
      alternateNames = listOf("Air Conditioner", "Window Air Conditioner"),
      imageName = "window-ac"
    )
    val airMattress = ItemToAdd(
      uuid = UUID.fromString("0ABE1865-2501-496E-AFEB-309A0DB1AFB4"),
      category = ItemCategory.OTHER,
      nameSingular = "Air Mattress",
      namePlural = "Air Mattresses",
      alternateNames = listOf("Inflatable Mattress", "Inflatable Bed", "Air Bed"),
      cft = 8,
      imageName = "air-mattress",
      families = listOf(mattresses, bedroom, attic, closet)
    )
    val armchair = ItemToAdd(
      uuid = UUID.fromString("33B2405F-FDCF-447F-AF23-0E9AD322AB44"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Armchair",
      namePlural = "Armchairs",
      cft = 16,
      imageName = "armchair",
      families = listOf(chairs, livingRoom, bedroom)
    )
    val armoire = ItemToAdd(
      uuid = UUID.fromString("65A46D85-4E74-450D-B8DA-9F8622FC12C2"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Armoire",
      namePlural = "Armoires",
      cft = 48,
      imageName = "armoire",
      families = listOf(drawers, diningRoom, livingRoom)
    )
    val babyBouncer = ItemToAdd(
      uuid = UUID.fromString("08D6D512-BC7A-46CA-BA0F-14F40452A4EE"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Baby Bouncer",
      namePlural = "Baby Bouncers",
      cft = 8,
      alternateNames = listOf("Rocker"),
      imageName = "baby-bouncer",
      families = listOf(kidsRoom)
    )
    val babyGate = ItemToAdd(
      uuid = UUID.fromString("1AEB4108-3B4E-4CCF-A84D-6BB5D6766813"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Baby Gate",
      namePlural = "Baby Gates",
      cft = 3,
      alternateNames = listOf("Dog Gate", "Stairs Gate"),
      imageName = "baby-gate",
      families = listOf(kidsRoom)
    )
    val babyGrandPiano = ItemToAdd(
      uuid = UUID.fromString("97CC8F06-CEA3-4279-9FAC-6ED9DD6D3418"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Baby Grand Piano",
      namePlural = "Baby Grand Pianos",
      cft = 112,
      imageName = "baby-grand-piano",
      isPotentiallyOversized = true,
      families = listOf(livingRoom, music)
    )
    val backpack = ItemToAdd(
      uuid = UUID.fromString("8A5E91C6-44CB-4B29-892D-D4E6E56B5D63"),
      category = ItemCategory.OTHER,
      nameSingular = "Backpack",
      namePlural = "Backpacks",
      cft = 3,
      imageName = "backpack",
      families = listOf(camping)
    )
    val bagOfClothes = ItemToAdd(
      uuid = UUID.fromString("FD9AA222-6598-42F0-BDFF-8D8515021725"),
      category = ItemCategory.OTHER,
      nameSingular = "Bag of Clothes",
      namePlural = "Bags of Clothes",
      cft = 8,
      alternateNames = listOf("Laundry Bag"),
      imageName = "laundry-bag",
      families = listOf(bedroom)
    )
    val bankersBox = ItemToAdd(
      uuid = UUID.fromString("095BE057-EBE6-4206-986B-D207E07D7A9F"),
      category = ItemCategory.BOX,
      nameSingular = "Bankers Box",
      namePlural = "Bankers Boxes",
      cft = 2,
      alternateNames = listOf("File Box, Filing Box"),
      imageName = "bankers-box",
      families = listOf(boxes, office, attic, closet)
    )
    val barCart = ItemToAdd(
      uuid = UUID.fromString("4B2CD920-9D7F-4D8A-905B-8622034C5032"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bar Cart",
      namePlural = "Bar Carts",
      cft = 16,
      imageName = "bar-cart",
      families = listOf(kitchen, diningRoom, livingRoom)
    )
    val basketballHoop = ItemToAdd(
      uuid = UUID.fromString("c096f849-050f-4e07-a02c-bad9b12d455f"),
      category = ItemCategory.OTHER,
      nameSingular = "Basketball Hoop",
      namePlural = "Basketball Hoops",
      cft = 24,
      imageName = "outdoor-basketball-hoop",
      families = listOf(exerciseEquipment, yard)
    )
    val arcadeMachine = ItemToAdd(
      uuid = UUID.fromString("9fc1a73f-601e-48e0-9932-64b61043e24f"),
      category = ItemCategory.OTHER,
      nameSingular = "Arcade Machine",
      namePlural = "Arcade Machines",
      cft = 40,
      imageName = "arcade-machine",
      families = listOf(entertainmentRoom)
    )
    val bathroomShelf = ItemToAdd(
      uuid = UUID.fromString("652337B2-0759-47F2-BEBF-E9BC27396204"),
      category = ItemCategory.BOX,
      nameSingular = "Bathroom Shelf",
      namePlural = "Bathroom Shelves",
      cft = 12,
      imageName = "bathroom-shelf",
      families = listOf(shelves, bathroom)
    )
    val bbq = ItemToAdd(
      uuid = UUID.fromString("BB1F57B5-99B9-4708-AFCC-2670EB091C02"),
      category = ItemCategory.OTHER,
      nameSingular = "Barbecue",
      namePlural = "Barbecues",
      cft = 24,
      alternateNames = listOf("Grill", "BBQ", "Barbeque"),
      imageName = "barbeque",
      families = listOf(deck, yard)
    )
    val beanBag = ItemToAdd(
      uuid = UUID.fromString("58B1FBDD-4568-4F8B-9FD7-6DDE4D7C6629"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bean Bag Chair",
      namePlural = "Bean Bag Chairs",
      cft = 40,
      imageName = "bean-bag",
      families = listOf(chairs, entertainmentRoom)
    )
    val bedLeg = ItemToAdd(
      uuid = UUID.fromString("805683DB-37AB-432C-AC2A-186EDA38CF71"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bed Leg",
      namePlural = "Bed Legs",
      cft = 1,
      imageName = "bed-leg",
      families = listOf(bedroom, bedFrames)
    )
    val bedsideLamp = ItemToAdd(
      uuid = UUID.fromString("D89FB05B-34F6-4093-9C91-F399A9971B06"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bedside Lamp",
      namePlural = "Bedside Lamps",
      cft = 3,
      imageName = "bedside-lamp",
      families = listOf(bedroom)
    )
    val bedsideTable = ItemToAdd(
      uuid = UUID.fromString("190AE082-2336-4B62-81E8-A3CCA4B5F182"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bedside Table",
      namePlural = "Bedside Tables",
      cft = 8,
      imageName = "end-table",
      alternateNames = listOf("Nightstand", "Night Stand"),
      families = listOf(tables, bedroom)
    )
    val bedsideTableDrawers = ItemToAdd(
      uuid = UUID.fromString("C7597018-6292-45D4-858A-FD944C57843A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Drawer Bedside Table",
      namePlural = "Drawer Bedside Tables",
      cft = 12,
      imageName = "drawer-night-stand",
      alternateNames = listOf("Drawer Nightstand", "Drawer Night Stand"),
      families = listOf(tables, drawers, bedroom)
    )
    val bedSideRails = ItemToAdd(
      uuid = UUID.fromString("8D39D946-257A-4574-9239-90B0D8623652"),
      category = ItemCategory.FURNITURE,
      nameGeneric = "Bed Rails",
      nameSingular = "Set of Bed Rails",
      namePlural = "Sets of Bed Rails",
      cft = 6,
      alternateNames = listOf("Bed Frame Rails", "Side Rails", "Bed Side Rails", "Sideboards"),
      imageName = "bed-side-rail",
      families = listOf(bedFrames, bedroom)
    )
    val bedSlats = ItemToAdd(
      uuid = UUID.fromString("41919BBA-CF30-413B-ABCA-5AAC59F0E6B1"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bed Slats",
      namePlural = "Bed Slats",
      cft = 3,
      imageName = "bed-slats",
      families = listOf(bedFrames, bedroom)
    )
    val bedTray = ItemToAdd(
      uuid = UUID.fromString("2C05628F-A251-4C6B-98FA-0C94A5E8E26A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bed Tray",
      namePlural = "Bed Trays",
      cft = 2,
      imageName = "bed-tray",
      families = listOf(kitchen, bedroom)
    )
    val bench = ItemToAdd(
      uuid = UUID.fromString("0905F4EB-6DF1-41CC-BF52-EA823AF20CBE"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bench",
      namePlural = "Benches",
      cft = 16,
      imageName = "bench",
      families = listOf(hallway, chairs)
    )
    val benchSeat = ItemToAdd(
      uuid = UUID.fromString("57BDE84C-9132-444B-AA8A-2DDECAB05C5B"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bench Seat",
      namePlural = "Bench Seats",
      cft = 10,
      imageName = "bench-seat",
      families = listOf(hallway, chairs)
    )
    val bicyclePump = ItemToAdd(
      uuid = UUID.fromString("F467A91F-61A3-42E5-881E-D49881611D0D"),
      category = ItemCategory.OTHER,
      nameSingular = "Bicycle Pump",
      namePlural = "Bicycle Pumps",
      cft = 2,
      imageName = "bicycle-pump",
      families = listOf(garage, shed, closet)
    )
    val bicycleTire = ItemToAdd(
      uuid = UUID.fromString("11FA69B8-BC94-4B22-95B3-6241804DFBF3"),
      category = ItemCategory.OTHER,
      nameSingular = "Bicycle Tire",
      namePlural = "Bicycle Tires",
      cft = 3,
      imageName = "bicycle-tire",
      families = listOf(garage, shed, closet)
    )
    val bicycleTrailer = ItemToAdd(
      uuid = UUID.fromString("76DEB494-7A0E-42FB-8414-FE167B9CDD87"),
      category = ItemCategory.OTHER,
      nameSingular = "Bicycle Trailer",
      namePlural = "Bicycle Trailers",
      cft = 24,
      imageName = "bicycle-trailer",
      families = listOf(garage, shed)
    )
    val bike = ItemToAdd(
      uuid = UUID.fromString("49C6A961-DE31-402D-9285-898292AA9175"),
      category = ItemCategory.OTHER,
      nameSingular = "Bike",
      namePlural = "Bikes",
      cft = 16,
      alternateNames = mutableListOf("Bicycle"),
      imageName = "bike",
      families = listOf(exerciseEquipment, garage, shed)
    )
    val bikeRack = ItemToAdd(
      uuid = UUID.fromString("C02AA7DC-19E7-45A8-9F67-E7B44EF2700F"),
      category = ItemCategory.OTHER,
      nameSingular = "Bike Rack",
      namePlural = "Bike Racks",
      cft = 16,
      imageName = "bike-rack",
      families = listOf(exerciseEquipment, garage, shed)
    )
    val boardGame = ItemToAdd(
      uuid = UUID.fromString("84B77F05-3D38-4B93-B74F-228636692792"),
      category = ItemCategory.OTHER,
      nameSingular = "Board Game",
      namePlural = "Board Games",
      cft = 2,
      imageName = "board-game",
      families = listOf(entertainmentRoom, livingRoom, bedroom, closet)
    )
    val bodyBoard = ItemToAdd(
      uuid = UUID.fromString("C6884473-D69E-4D15-B140-81996AED6D2B"),
      category = ItemCategory.OTHER,
      nameSingular = "Body Board",
      namePlural = "Body Board",
      cft = 4,
      imageName = "body-board",
      families = listOf(exerciseEquipment, garage, shed, closet)
    )
    val bookcase = ItemToAdd(
      uuid = UUID.fromString("291E2B8C-3249-47B2-923C-85AE3AE93F0F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bookcase",
      namePlural = "Bookcases",
      cft = 24,
      imageName = "bookcase",
      families = listOf(shelves, bedroom, livingRoom, hallway)
    )
    val bookcaseNarrow = ItemToAdd(
      uuid = UUID.fromString("859433F6-2B18-42E6-81B8-CED26C1AF6AB"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Narrow Bookcase",
      namePlural = "Narrow Bookcases",
      cft = 12,
      imageName = "narrow-bookcase",
      families = listOf(shelves, bedroom, livingRoom, hallway)
    )
    val bookcaseShort = ItemToAdd(
      uuid = UUID.fromString("FF9A47A7-C617-4237-A67B-9580523BFEB3"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Short Bookcase",
      namePlural = "Short Bookcases",
      cft = 16,
      imageName = "short-bookcase",
      families = listOf(shelves, bedroom, livingRoom, hallway)
    )
    val bosuBall = ItemToAdd(
      uuid = UUID.fromString("88EE02C3-AF79-49D8-9F52-6210E24B5AB5"),
      category = ItemCategory.OTHER,
      nameSingular = "Bosu Ball",
      namePlural = "Bosu Balls",
      cft = 10,
      imageName = "bosu-ball",
      alternateNames = listOf("Yoga Ball"),
      families = listOf(exerciseEquipment, gym)
    )
    val briefcase = ItemToAdd(
      uuid = UUID.fromString("1AE40942-3EBE-4F27-A589-99ACE879C7F8"),
      category = ItemCategory.OTHER,
      nameSingular = "Briefcase",
      namePlural = "Briefcases",
      cft = 3,
      imageName = "briefcase",
      families = listOf(office)
    )
    val broom = ItemToAdd(
      uuid = UUID.fromString("79F817D1-9B1C-4365-ABD4-62B164AF4B12"),
      category = ItemCategory.OTHER,
      nameSingular = "Broom",
      namePlural = "Brooms",
      cft = 4,
      alternateNames = listOf("Broomstick", "Swiffer"),
      imageName = "broomstick",
      families = listOf(closet, garage)
    )
    val bucket = ItemToAdd(
      uuid = UUID.fromString("B4B5616B-D6FA-49D8-AD75-9A90C1A22A0E"),
      category = ItemCategory.OTHER,
      nameSingular = "Bucket",
      namePlural = "Buckets",
      cft = 2,
      imageName = "bucket",
      families = listOf(closet, garage, shed, yard)
    )
    val bunkBed = ItemToAdd(
      uuid = UUID.fromString("93BFAF7D-846C-43D0-906D-9CDAA1DF671B"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Bunk Bed",
      namePlural = "Bunk Bed",
      cft = 40,
      imageName = "bunk-bed",
      families = listOf(bedFrames, kidsRoom)
    )
    val bundleOfSticks = ItemToAdd(
      uuid = UUID.fromString("3E1D9E1B-C4D3-482C-985E-47D0ECEB6B3F"),
      category = ItemCategory.OTHER,
      nameSingular = "Bundle of Sticks",
      namePlural = "Bundles of Sticks",
      cft = 6,
      imageName = "bundle-of-sticks",
      families = listOf(yard, shed)
    )
    val buffet = ItemToAdd(
      uuid = UUID.fromString("8D80EA11-4080-44D5-A1C1-2798ADE5C668"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Credenza",
      namePlural = "Credenzas",
      cft = 24,
      alternateNames = listOf("Buffet", "Sideboard"),
      imageName = "credenza",
      families = listOf(cabinets, diningRoom)
    )
    val butcherBlockTable = ItemToAdd(
      uuid = UUID.fromString("A22C3010-3440-4C4B-A017-ABF09D8A38B4"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Butcher Block Table",
      namePlural = "Butch Block Tables",
      cft = 24,
      imageName = "butcher-block-table",
      families = listOf(tables, kitchen)
    )
    val cabinet = ItemToAdd(
      uuid = UUID.fromString("2F712BAC-505F-418F-A324-8ACF2518615F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Cabinet",
      namePlural = "Cabinets",
      cft = 24,
      imageName = "cabinet",
      families = listOf(cabinets, diningRoom, livingRoom)
    )
    val campingGear = ItemToAdd(
      uuid = UUID.fromString("66884198-660E-4ABA-A96A-4AF741162FB1"),
      category = ItemCategory.OTHER,
      nameGeneric = "Camping Gear",
      nameSingular = "Set of Camping Gear",
      namePlural = "Sets of Camping Gear",
      cft = 12,
      imageName = "camping-gear",
      families = listOf(closet, garage, shed, attic, camping)
    )
    val candelabra = ItemToAdd(
      uuid = UUID.fromString("FD79AB72-C55E-43EB-B62B-490DECEC68C8"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Candelabra",
      namePlural = "Candelabras",
      cft = 3,
      alternateNames = listOf("Candle Sticks"),
      imageName = "candelabra",
      families = listOf(diningRoom)
    )
    val canvasBag = ItemToAdd(
      uuid = UUID.fromString("41D64399-6B80-45B9-B584-B44B0F60344C"),
      category = ItemCategory.OTHER,
      nameSingular = "Canvas Bag",
      namePlural = "Canvas Bags",
      cft = 3,
      imageName = "canvas-bag"
    )
    val carSeat = ItemToAdd(
      uuid = UUID.fromString("F2876E80-155C-4E50-A967-7C02712B2593"),
      category = ItemCategory.OTHER,
      nameSingular = "Car Seat",
      namePlural = "Car Seats",
      cft = 8,
      imageName = "car-seat",
      alternateNames = listOf("Booster Seat"),
      families = listOf(garage, kidsRoom)
    )
    val carTopCarrier = ItemToAdd(
      uuid = UUID.fromString("CB5A6320-F54E-42BE-88C7-223D3173CF94"),
      category = ItemCategory.OTHER,
      nameSingular = "Car Top Carrier",
      namePlural = "Car Top Carriers",
      cft = 20,
      alternateNames = listOf("Rooftop Cargo Carrier", "SkyBox", "RocketBox", "Cargo Box"),
      imageName = "car-top-carrier",
      families = listOf(garage)
    )
    val cardTable = ItemToAdd(
      uuid = UUID.fromString("0D515D9F-0506-443E-AD56-2082AB807DF8"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Card Table",
      namePlural = "Card Tables",
      cft = 16,
      imageName = "card-table",
      families = listOf(tables, closet)
    )
    val catTree = ItemToAdd(
      uuid = UUID.fromString("6EFF5571-67B0-427C-B9CD-5F5CB35122AE"),
      category = ItemCategory.OTHER,
      nameSingular = "Cat Tree",
      namePlural = "Cat Trees",
      cft = 10,
      imageName = "cat-tree",
      alternateNames = listOf("Cat Tower"),
      families = listOf(bedroom, livingRoom)
    )
    val cdTower = ItemToAdd(
      uuid = UUID.fromString("D9808F01-2A3A-4FF1-B953-49A74BAABF66"),
      category = ItemCategory.FURNITURE,
      nameSingular = "CD Tower",
      namePlural = "CD Towers",
      cft = 10,
      alternateNames = listOf("CD Shelf"),
      imageName = "cd-tower",
      families = listOf(entertainmentRoom, livingRoom)
    )
    val ceilingFan = ItemToAdd(
      uuid = UUID.fromString("912652FA-3AA6-4811-8325-EEC473B3D8D8"),
      category = ItemCategory.OTHER,
      nameSingular = "Ceiling Fan",
      namePlural = "Ceiling Fans",
      cft = 6,
      imageName = "ceiling-fan",
      families = listOf(bedroom)
    )
    val chaiseLounge = ItemToAdd(
      uuid = UUID.fromString("7DCC9816-08B3-4544-A0FE-2C834E0C31FD"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Chaise Lounge",
      namePlural = "Chaise Lounges",
      cft = 32,
      imageName = "chaise-lounge",
      families = listOf(chairs, sofas, livingRoom, bedroom)
    )
    val chalkboard = ItemToAdd(
      uuid = UUID.fromString("1B4AFE7E-51CC-4151-BBDB-F960DD1BF205"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Chalkboard",
      namePlural = "Chalkboards",
      cft = 8,
      alternateNames = listOf("Black Board"),
      imageName = "chalkboard",
      families = listOf(kidsRoom, office)
    )
    val chandelier = ItemToAdd(
      uuid = UUID.fromString("F547E474-9B80-4A13-8FE9-4A731E4B92B8"),
      category = ItemCategory.OTHER,
      nameSingular = "Chandelier",
      namePlural = "Chandeliers",
      cft = 40,
      imageName = "chandelier",
      families = listOf(diningRoom)
    )
    val chandelierSmall = ItemToAdd(
      uuid = UUID.fromString("009D91A6-6C85-416B-8E27-936AC7568A27"),
      category = ItemCategory.OTHER,
      nameSingular = "Small Chandelier",
      namePlural = "Small Chandeliers",
      cft = 16,
      imageName = "chandelier",
      families = listOf(diningRoom)
    )
    val changingTable = ItemToAdd(
      uuid = UUID.fromString("e94025b9-12c6-4ccc-8f00-456218b63b0a"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Changing Table",
      namePlural = "Changing Tables",
      cft = 20,
      imageName = "changing-table",
      families = listOf(tables, bathroom, kidsRoom)
    )
    val chestSmall = ItemToAdd(
      uuid = UUID.fromString("9c08f0f7-cc19-41c8-a6cf-be03e8e51cd4"),
      category = ItemCategory.BOX,
      nameSingular = "Small Chest",
      namePlural = "Small Chests",
      cft = 2,
      imageName = "wooden-chest",
      alternateNames = listOf("Small Wooden Chest", "Small Trunk", "Small Metal Chest"),
      families = listOf(bins)
    )
    val chestMedium = ItemToAdd(
      uuid = UUID.fromString("6D329B15-61F9-43D1-82BC-91B5AC80AD59"),
      category = ItemCategory.BOX,
      nameSingular = "Medium Chest",
      namePlural = "Medium Chests",
      cft = 4,
      imageName = "wooden-chest",
      alternateNames = listOf("Medium Wooden Chest", "Medium Trunk", "Medium Metal Chest"),
      families = listOf(bins)
    )
    val chestLarge = ItemToAdd(
      uuid = UUID.fromString("C71640C7-8798-49BA-91BF-01C1D30BD4BA"),
      category = ItemCategory.BOX,
      nameSingular = "Large Chest",
      namePlural = "Large Chests",
      cft = 8,
      imageName = "wooden-chest",
      alternateNames = listOf("Large Wooden Chest", "Large Trunk", "Large Metal Chest"),
      families = listOf(bins)
    )
    val chinaHutch2pc = ItemToAdd(
      uuid = UUID.fromString("C7467AA6-147B-4488-B0AA-E84B000671F5"),
      category = ItemCategory.FURNITURE,
      nameSingular = "2pc China Hutch",
      namePlural = "2pc China Hutches",
      cft = 80,
      imageName = "2-piece-china-hutch",
      alternateNames = listOf("2pc China Cabinet", "Breakfront", "Two piece China Hutch"),
      families = listOf(drawers, cabinets, diningRoom)
    )
    val christmasLawnOrnament = ItemToAdd(
      uuid = UUID.fromString("24E93FF8-E1CF-4A7E-AC6F-51BB5BB7704D"),
      category = ItemCategory.OTHER,
      nameSingular = "Christmas Lawn Ornament",
      namePlural = "Christmas Lawn Ornaments",
      cft = 16,
      imageName = "christmas-lawn-ornament",
      families = listOf(yard, attic, garage, closet)
    )
    val christmasTree = ItemToAdd(
      uuid = UUID.fromString("0177A7A5-31D0-40CF-B253-B6FCD757E8C5"),
      category = ItemCategory.OTHER,
      nameSingular = "Christmas Tree",
      namePlural = "Christmas Trees",
      cft = 20,
      imageName = "christmas-tree",
      families = listOf(yard, attic, garage, closet)
    )
    val coatStand = ItemToAdd(
      uuid = UUID.fromString("8D1948C3-BBFC-43C4-8FFB-B970FF4D2B1F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Coat Rack",
      namePlural = "Coat Racks",
      cft = 8,
      alternateNames = listOf("Coat Stand"),
      imageName = "coat-stand",
      families = listOf(hallway)
    )
    val coffeeMaker = ItemToAdd(
      uuid = UUID.fromString("73F881E8-2CE4-4FBC-B62C-07E7F30824B9"),
      category = ItemCategory.OTHER,
      nameSingular = "Coffee Maker",
      namePlural = "Coffee Makers",
      cft = 3,
      imageName = "coffee-maker",
      families = listOf(kitchen)
    )
    val coffeeTable = ItemToAdd(
      uuid = UUID.fromString("3BE6B86B-5203-4007-93D6-132401997D8A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Coffee Table",
      namePlural = "Coffee Tables",
      cft = 16,
      imageName = "coffee-table",
      families = listOf(tables, livingRoom, entertainmentRoom)
    )
    val comforter = ItemToAdd(
      uuid = UUID.fromString("F0C3E987-A5FF-4943-A0CE-531D327EA568"),
      category = ItemCategory.OTHER,
      nameSingular = "Comforter",
      namePlural = "Comforter",
      cft = 6,
      alternateNames = listOf("Comforter in Bag"),
      imageName = "comforter-in-bag",
      families = listOf(bedroom, closet, attic)
    )
    val concertPiano = ItemToAdd(
      uuid = UUID.fromString("0774B5E4-700A-453D-8A3E-B5CA4EFA94B6"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Concert Piano",
      namePlural = "Concert Pianos",
      cft = 160,
      imageName = "baby-grand-piano",
      families = listOf(livingRoom, music),
      isPotentiallyOversized = true
    )
    val conferenceTable = ItemToAdd(
      uuid = UUID.fromString("75B71903-8FA1-43CD-9023-3C9889F35019"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Conference Table",
      namePlural = "Conference Tables",
      cft = 112,
      alternateNames = listOf("Office Table"),
      imageName = "conference-table",
      families = listOf(tables),
      isPotentiallyOversized = true
    )
    val consoleTable = ItemToAdd(
      uuid = UUID.fromString("094C77FA-E774-4DFD-B39E-71085183F821"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Console Table",
      namePlural = "Console Tables",
      cft = 16,
      imageName = "console-table",
      families = listOf(tables, hallway, diningRoom, livingRoom, bedroom)
    )
    val cooler = ItemToAdd(
      uuid = UUID.fromString("6912793B-EBC3-4B12-83B6-55A6A041E77D"),
      category = ItemCategory.BOX,
      nameSingular = "Cooler",
      namePlural = "Coolers",
      cft = 6,
      alternateNames = listOf("Ice Box", "Ice Chest"),
      imageName = "cooler",
      families = listOf(bins, kitchen)
    )
    val corkBoard = ItemToAdd(
      uuid = UUID.fromString("C378B0D1-E8CE-4138-8554-DBBD774B1D6C"),
      category = ItemCategory.OTHER,
      nameSingular = "Cork Board",
      namePlural = "Cork Boards",
      cft = 2,
      alternateNames = listOf("Bulletin Board"),
      imageName = "cork-board",
      families = listOf(kitchen, hallway)
    )
    val couchCushion = ItemToAdd(
      uuid = UUID.fromString("2F7E534C-2367-4309-A2D9-676B3C4BA7AC"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Couch Cushion",
      namePlural = "Couch Cushions",
      cft = 6,
      alternateNames = listOf("Sofa Cushion", "Sofa Pillows", "Couch Pillows"),
      imageName = "couch-cushions",
      families = listOf(sofas, livingRoom, entertainmentRoom)
    )
    val cradle = ItemToAdd(
      uuid = UUID.fromString("698F2B7A-E857-4AFC-A4CF-63B27C3B75D1"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Cradle",
      namePlural = "Cradles",
      cft = 6,
      imageName = "cradle",
      families = listOf(kidsRoom, bedFrames)
    )
    val crib = ItemToAdd(
      uuid = UUID.fromString("AC64BB23-0519-437D-9C23-62B84560827D"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Crib",
      namePlural = "Cribs",
      cft = 12,
      imageName = "crib",
      families = listOf(kidsRoom, bedFrames)
    )
    val crutches = ItemToAdd(
      uuid = UUID.fromString("82F95131-6DAA-451C-BAC5-53D6397AD79A"),
      category = ItemCategory.OTHER,
      nameSingular = "Crutches",
      namePlural = "Crutches",
      cft = 3,
      imageName = "crutches"
    )
    val cubbyBin = ItemToAdd(
      uuid = UUID.fromString("7F50C72F-7B64-42A9-9034-521E67DF5CC9"),
      category = ItemCategory.BOX,
      nameSingular = "Cubby Bin",
      namePlural = "Cubby Bins",
      cft = 3,
      imageName = "cubby-bin",
      families = listOf(bins, bedroom)
    )
    val cubicleWall = ItemToAdd(
      uuid = UUID.fromString("9EDE1748-5272-4A86-9B3A-67E318517376"),
      category = ItemCategory.OTHER,
      nameSingular = "Cubicle Wall",
      namePlural = "Cubicle Walls",
      cft = 16,
      imageName = "cubicle-wall",
      families = listOf(office)
    )
    val curtainsAndRods = ItemToAdd(
      uuid = UUID.fromString("95370679-574D-4FF4-A92A-4805CCF2627B"),
      category = ItemCategory.OTHER,
      nameSingular = "Curtains and Rods",
      namePlural = "Curtains and Rods",
      cft = 5,
      alternateNames = listOf("Window Shades"),
      imageName = "curtains-and-rods",
      families = listOf(bathroom)
    )
    val craftsmanCabinet = ItemToAdd(
      uuid = UUID.fromString("637BFBE9-6BC8-477A-A86B-5A6D11BB54B8"),
      category = ItemCategory.OTHER,
      nameSingular = "Craftsman Cabinet",
      namePlural = "Craftsman Cabinets",
      cft = 30,
      imageName = "craftsman-cabinet",
      families = listOf(cabinets, garage, workshop, shed)
    )
    val deepFryer = ItemToAdd(
      uuid = UUID.fromString("0575022C-AE27-4864-BB07-FCAD9F2D7599"),
      category = ItemCategory.OTHER,
      nameSingular = "Deep Fryer",
      namePlural = "Deep Fryers",
      cft = 4,
      imageName = "deep-fryer",
      families = listOf(kitchen)
    )
    val desktopComputer = ItemToAdd(
      uuid = UUID.fromString("3A8440DE-4822-4F10-A0DC-9F49FF1E873E"),
      category = ItemCategory.OTHER,
      nameSingular = "Desktop Computer",
      namePlural = "Desktop Computers",
      cft = 4,
      alternateNames = listOf("Computer Tower"),
      imageName = "desktop-computer",
      families = listOf(office, entertainmentRoom, bedroom)
    )
    val dehumidifier = ItemToAdd(
      uuid = UUID.fromString("FEE31776-87B2-4A6D-9474-239ED01184E7"),
      category = ItemCategory.OTHER,
      nameSingular = "Dehumidifier",
      namePlural = "Dehumidifiers",
      cft = 8,
      imageName = "dehumidifier"
    )
    val deskWithDrawers = ItemToAdd(
      uuid = UUID.fromString("DB27EF0C-095D-4500-839A-404D908DAA69"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Desk with Drawers",
      namePlural = "Desks with Drawers",
      cft = 32,
      imageName = "desk-with-drawers",
      families = listOf(tables, office)
    )
    val didgeridoo = ItemToAdd(
      uuid = UUID.fromString("CEF96816-173C-4A45-ACCB-1D55AE6BAD97"),
      category = ItemCategory.OTHER,
      nameSingular = "Didgeridoo",
      namePlural = "Didgeridoos",
      cft = 5,
      imageName = "didgeridoo",
      families = listOf(music)
    )
    val digitalMixer = ItemToAdd(
      uuid = UUID.fromString("5C0B52CC-C2CD-4308-A618-3F0C5A96AAA9"),
      category = ItemCategory.OTHER,
      nameSingular = "Digital Mixer",
      namePlural = "Digital Mixers",
      cft = 12,
      alternateNames = listOf("Sound Board"),
      imageName = "digital-mixer",
      families = listOf(music)
    )
    val diningRoomChair = ItemToAdd(
      uuid = UUID.fromString("61FA871D-B74D-4F70-A1A8-F9941B7F4FFB"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Dining Room Chair",
      namePlural = "Dining Room Chairs",
      cft = 8,
      alternateNames = listOf("Desk Chair", "Dining Chair"),
      imageName = "dining-chair",
      families = listOf(chairs, diningRoom)
    )
    val diningTableLeaf = ItemToAdd(
      uuid = UUID.fromString("B16E6FFF-16EC-4175-84F7-F23CEB64D051"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Dining Table Leaf",
      namePlural = "Dining Table Leaves",
      cft = 4,
      imageName = "dining-table-leaf",
      families = listOf(tables, diningRoom)
    )
    val diningTableGlass = ItemToAdd(
      uuid = UUID.fromString("11568C0F-21BB-4E05-B6EE-AEBB80AA03F4"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Glass Table Top",
      namePlural = "Glass Table Tops",
      cft = 6,
      alternateNames = listOf("Dining Table Glass"),
      imageName = "glass-table-top",
      families = listOf(tables, diningRoom)
    )
    val diningRoomTable = ItemToAdd(
      uuid = UUID.fromString("499B6835-B8E2-40B9-B5B3-2EE64ED746C0"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Dining Table",
      namePlural = "Dining Tables",
      cft = 48,
      imageName = "dining-table",
      alternateNames = listOf("Dinner Table"),
      families = listOf(tables, diningRoom),
      isPotentiallyOversized = true
    )
    val dishPack = ItemToAdd(
      uuid = UUID.fromString("18A77555-7EBC-4C09-856D-38C7DD8BCA6D"),
      category = ItemCategory.BOX,
      nameSingular = "Dish Pack",
      namePlural = "Dish Packs",
      cft = 7,
      imageName = "dish-box",
      alternateNames = listOf("Dish Box"),
      families = listOf(boxes, kitchen)
    )
    val dishPackMini = ItemToAdd(
      uuid = UUID.fromString("E792AA8F-BB1D-4E24-9D85-D1E4392ACF57"),
      category = ItemCategory.BOX,
      nameSingular = "Mini Dish Pack",
      namePlural = "Mini Dish Packs",
      cft = 4,
      imageName = "dish-box",
      alternateNames = listOf("Mini Dish Box"),
      families = listOf(boxes, kitchen)
    )
    val dishwasher = ItemToAdd(
      uuid = UUID.fromString("8720DD78-AEC9-4872-B789-65E4B74548FE"),
      category = ItemCategory.OTHER,
      nameSingular = "Dishwasher",
      namePlural = "Dishwashers",
      cft = 24,
      imageName = "dishwasher",
      families = listOf(kitchen)
    )
    val dogBed = ItemToAdd(
      uuid = UUID.fromString("03D7B408-2CD9-4406-A610-1E4040FB381D"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Dog Bed",
      namePlural = "Dog Beds",
      cft = 8,
      imageName = "dog-bed"
    )
    val dollhouse = ItemToAdd(
      uuid = UUID.fromString("630BFAD6-5494-4665-BDF6-C1FE8319FE6D"),
      category = ItemCategory.OTHER,
      nameSingular = "Dollhouse",
      namePlural = "Dollhouses",
      cft = 6,
      imageName = "dollhouse",
      families = listOf(kidsRoom)
    )
    val dollyHand = ItemToAdd(
      uuid = UUID.fromString("BDFEF0BF-7551-48E2-9993-56630C136207"),
      category = ItemCategory.OTHER,
      nameSingular = "Hand Truck",
      namePlural = "Hand Trucks",
      cft = 5,
      alternateNames = listOf("Hand Dolly", "2 Wheel Dolly"),
      imageName = "hand-truck",
      families = listOf(yard, garage, shed, attic)
    )
    val dollyFurniture = ItemToAdd(
      uuid = UUID.fromString("7201EEA5-2CBB-4647-8043-8F05DBBE633F"),
      category = ItemCategory.OTHER,
      nameSingular = "Furniture Dolly",
      namePlural = "Furniture Dollies",
      cft = 3,
      alternateNames = listOf("Moving Dolly", "4 Wheel Dolly"),
      imageName = "moving-dolly",
      families = listOf(yard, garage, shed, attic)
    )
    val door = ItemToAdd(
      uuid = UUID.fromString("6E6B2658-2B4A-4697-9DA9-5D0B81DC2CD8"),
      category = ItemCategory.OTHER,
      nameSingular = "Door",
      namePlural = "Doors",
      cft = 12,
      imageName = "door",
      alternateNames = listOf("Wood Door", "Wooden Door")
    )
    val doorMat = ItemToAdd(
      uuid = UUID.fromString("0B6B5380-EE57-4219-B3ED-6467E8E93F2B"),
      category = ItemCategory.OTHER,
      nameSingular = "Door Mat",
      namePlural = "Door Mats",
      cft = 3,
      imageName = "door-mat",
      families = listOf(yard, hallway)
    )
    val doubleBedFrame = ItemToAdd(
      uuid = UUID.fromString("915A65B2-0F80-4608-907E-E08FCEBE7B28"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Double Bed Frame",
      namePlural = "Double Bed Frames",
      cft = 32,
      imageName = "bed-frame",
      alternateNames = listOf("Full Bed Frame"),
      families = listOf(bedFrames, bedroom)
    )
    val doubleBoxSpring = ItemToAdd(
      uuid = UUID.fromString("D33C311E-4FB8-41DD-8F10-7ACDB8C454C8"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Double Box Spring",
      namePlural = "Double Box Springs",
      cft = 42,
      alternateNames = listOf("Double Bed Box Spring"),
      imageName = "box-spring",
      families = listOf(boxSprings, bedroom)
    )
    val doubleDresser = ItemToAdd(
      uuid = UUID.fromString("2FDE1E8E-C6F7-4972-846A-155BEEF6641A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Double Dresser",
      namePlural = "Double Dressers",
      cft = 28,
      imageName = "double-dresser",
      families = listOf(dressers, drawers, bedroom)
    )
    val doubleMattress = ItemToAdd(
      uuid = UUID.fromString("26B36673-F61E-4A64-A743-6780B79B8112"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Double Mattress",
      namePlural = "Double Mattresses",
      cft = 32,
      alternateNames = listOf("Double Bed Mattress", "Full Mattress"),
      imageName = "mattress",
      families = listOf(mattresses, bedroom)
    )
    val doubleOven = ItemToAdd(
      uuid = UUID.fromString("E27E7313-BC02-44D7-B825-1B88CA6F59D0"),
      category = ItemCategory.OTHER,
      nameSingular = "Double Oven",
      namePlural = "Double Ovens",
      cft = 72,
      alternateNames = listOf("Double Bed Mattress", "Full Mattress"),
      imageName = "double-oven",
      families = listOf(kitchen)
    )
    val draftingTable = ItemToAdd(
      uuid = UUID.fromString("4A643E8C-7BC0-4895-8D38-E8D657CFFCF6"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Drafting Table",
      namePlural = "Drafting Tables",
      cft = 24,
      imageName = "drafting-table",
      families = listOf(tables, office, workshop)
    )
    val dropLeafTable = ItemToAdd(
      uuid = UUID.fromString("AE9EFC06-8FD6-4130-A1D3-FF3FAC07F34E"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Drop Leaf Table",
      namePlural = "Drop Leaf Tables",
      cft = 32,
      imageName = "drop-leaf-table",
      families = listOf(tables, diningRoom)
    )
    val singleDrawer = ItemToAdd(
      uuid = UUID.fromString("EE6BEEDE-86F6-41F6-8A7F-1062F623B024"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Single Drawer",
      namePlural = "Drawers",
      cft = 3,
      imageName = "single-drawer",
      families = listOf(dressers, drawers, bedroom)
    )
    val drum = ItemToAdd(
      uuid = UUID.fromString("C65109C6-43DF-4DC0-93AB-406C8FC24156"),
      category = ItemCategory.OTHER,
      nameSingular = "Drum",
      namePlural = "Drums",
      cft = 8,
      imageName = "drum",
      families = listOf(music)
    )
    val drums = ItemToAdd(
      uuid = UUID.fromString("64EA88DE-9A86-4A45-8A86-955927B1B9B3"),
      category = ItemCategory.OTHER,
      nameSingular = "Drum Set",
      namePlural = "Drum Sets",
      cft = 32,
      imageName = "drums",
      families = listOf(music)
    )
    val dryer = ItemToAdd(
      uuid = UUID.fromString("0AEC7495-3843-4B1F-9D00-E0BBE0D6FF59"),
      category = ItemCategory.OTHER,
      nameSingular = "Dryer",
      namePlural = "Dryers",
      cft = 20,
      imageName = "dryer",
      families = listOf(laundryRoom, hallway, garage)
    )
    val duffelBag = ItemToAdd(
      uuid = UUID.fromString("CCE8738D-4D4F-44FA-AAFB-E3F268427505"),
      category = ItemCategory.OTHER,
      nameSingular = "Duffel Bag",
      namePlural = "Duffel Bags",
      cft = 4,
      alternateNames = listOf("Duffle Bag", "Sports Bag", "Gym Bag"),
      imageName = "duffel-bag"
    )
    val dumbbells = ItemToAdd(
      uuid = UUID.fromString("DFFC52EF-AF55-4762-A44E-0171AD16D2C5"),
      category = ItemCategory.OTHER,
      nameSingular = "Dumbbells",
      namePlural = "Sets of Dumbbells",
      cft = 3,
      imageName = "dumbbells",
      families = listOf(exerciseEquipment, gym)
    )
    val dumbbellRack = ItemToAdd(
      uuid = UUID.fromString("96908B0C-1FDB-4711-B293-12EBF8FB122A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Dumbbell Rack",
      namePlural = "Dumbbell Racks",
      cft = 12,
      imageName = "dumbell-rack",
      families = listOf(exerciseEquipment, gym)
    )
    val easel = ItemToAdd(
      uuid = UUID.fromString("BCB7D37E-2F3C-4698-BE4F-CE0E31DA3A73"),
      category = ItemCategory.OTHER,
      nameSingular = "Easel",
      namePlural = "Easels",
      cft = 6,
      imageName = "easel",
      families = listOf(art, workshop)
    )
    val electricFireplace = ItemToAdd(
      uuid = UUID.fromString("1E4025E4-B190-48BF-AE5C-31C596E673F8"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Electric Fireplace",
      namePlural = "Electric Fireplaces",
      cft = 16,
      imageName = "electric-fireplace",
      families = listOf(livingRoom)
    )
    val electricGenerator = ItemToAdd(
      uuid = UUID.fromString("85D786DD-7BE7-4FF8-8DF5-3AB6A3D3CD85"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Electric Generator",
      namePlural = "Electric Generators",
      cft = 8,
      imageName = "electric-generator",
      families = listOf(shed, garage)
    )
    val endTable = ItemToAdd(
      uuid = UUID.fromString("F2085AA9-73DD-465C-B93F-AD0382CE9702"),
      category = ItemCategory.FURNITURE,
      nameSingular = "End Table",
      namePlural = "End Tables",
      cft = 12,
      imageName = "end-table",
      alternateNames = listOf("Side Table"),
      families = listOf(tables, livingRoom, entertainmentRoom)
    )
    val exerciseBike = ItemToAdd(
      uuid = UUID.fromString("BF95B196-01BE-4DFD-8966-D3BABCCE41E9"),
      category = ItemCategory.OTHER,
      nameSingular = "Exercise Bike",
      namePlural = "Exercise Bikes",
      cft = 32,
      imageName = "exercise-bike",
      alternateNames = listOf("Stationary Bike"),
      families = listOf(exerciseEquipment, gym)
    )
    val exerciseEquipmentSmall = ItemToAdd(
      uuid = UUID.fromString("DAE4240C-71E0-4FAE-9988-4EE52BFA4720"),
      category = ItemCategory.OTHER,
      nameSingular = "Small Exercise Equipment",
      namePlural = "Sets of Small Exercise Equipment",
      cft = 16,
      imageName = "exercise-equipment",
      alternateNames = listOf("Weights", "Pull Up Bar"),
      families = listOf(exerciseEquipment, gym)
    )
    val exerciseEquipmentLarge = ItemToAdd(
      uuid = UUID.fromString("2CDB3B2E-C2F3-433F-8EC6-949A68F3EFB5"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Exercise Equipment",
      namePlural = "Sets of Large Exercise Equipment",
      cft = 32,
      imageName = "exercise-equipment",
      alternateNames = listOf("Bowflex", "Bench Press"),
      families = listOf(exerciseEquipment, gym),
      isPotentiallyOversized = true
    )
    val extraLargeBox = ItemToAdd(
      uuid = UUID.fromString("0A4EE7B0-B216-486A-97F3-2B31A953918C"),
      category = ItemCategory.BOX,
      nameSingular = "Extra-Large Box",
      namePlural = "Extra-Large Boxes",
      cft = 9,
      imageName = "box",
      families = listOf(boxes)
    )
    val extraSmallBox = ItemToAdd(
      uuid = UUID.fromString("1D852B57-EF6A-43AD-BF90-D83561FBF905"),
      category = ItemCategory.BOX,
      nameSingular = "Extra Small Box",
      namePlural = "Extra Small Boxes",
      cft = 1,
      imageName = "box",
      families = listOf(boxes)
    )
    val ezUp = ItemToAdd(
      uuid = UUID.fromString("330365C5-13B9-4EA4-9C87-F7795C445D0E"),
      category = ItemCategory.OTHER,
      nameSingular = "E-Z Up",
      namePlural = "E-Z Ups",
      cft = 6,
      imageName = "e-z-up",
      alternateNames = listOf("Caravan Canopy", "Canopy")
    )
    val filingCabinet = ItemToAdd(
      uuid = UUID.fromString("91879F47-A39F-4B30-B418-7BBD495383E0"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Filing Cabinet",
      namePlural = "Filing Cabinets",
      cft = 16,
      imageName = "filing-cabinet",
      families = listOf(drawers, office, attic, garage)
    )
    val fan = ItemToAdd(
      uuid = UUID.fromString("4446CD1B-C538-4E06-8802-E0835F029067"),
      category = ItemCategory.OTHER,
      nameSingular = "Fan",
      namePlural = "Fans",
      cft = 6,
      alternateNames = listOf("Box Fan"),
      imageName = "box-fan",
      families = listOf(bedroom)
    )
    val fiftyFiveGallonDrum = ItemToAdd(
      uuid = UUID.fromString("1DB42CA8-CFB5-4114-843E-187F5B7EF9E7"),
      category = ItemCategory.OTHER,
      nameSingular = "55 Gallon Drum",
      namePlural = "55 Gallon Drums",
      cft = 11,
      imageName = "55-gallon",
      families = listOf(workshop, garage, shed, yard)
    )
    val fireplaceEquipment = ItemToAdd(
      uuid = UUID.fromString("ECAD0032-3A98-4EDD-BFB7-EE983510A2B8"),
      category = ItemCategory.OTHER,
      nameGeneric = "Fireplace Equipment",
      nameSingular = "Set of Fireplace Equipment",
      namePlural = "Sets of Fireplace Equipment",
      cft = 5,
      imageName = "fireplace-equipment",
      families = listOf(livingRoom)
    )
    val fishingRod = ItemToAdd(
      uuid = UUID.fromString("787CBE09-800D-46E4-A93D-7A4E2D0076A0"),
      category = ItemCategory.OTHER,
      nameSingular = "Fishing Rod",
      namePlural = "Fishing Rods",
      cft = 3,
      imageName = "fishing-rod",
      families = listOf(closet, garage, shed, attic)
    )
    val floorLamp = ItemToAdd(
      uuid = UUID.fromString("B5A3E212-6DA5-4139-AB6C-2099A8BC96B2"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Floor Lamp",
      namePlural = "Floor Lamps",
      cft = 6,
      imageName = "floor-lamp",
      families = listOf(bedroom, office, livingRoom, entertainmentRoom)
    )
    val flowerPot = ItemToAdd(
      uuid = UUID.fromString("36FB54DB-043E-4AC0-8FB5-857C28080A7F"),
      category = ItemCategory.OTHER,
      nameSingular = "Flower Pot",
      namePlural = "Flower Pots",
      cft = 3,
      imageName = "flower-pot",
      families = listOf(yard, shed, garage, deck)
    )
    val foamRoller = ItemToAdd(
      uuid = UUID.fromString("4061C463-4F93-4BED-9B55-47E8429AE960"),
      category = ItemCategory.OTHER,
      nameSingular = "Foam Roller",
      namePlural = "Foam Rollers",
      cft = 3,
      imageName = "foam-roller",
      families = listOf(exerciseEquipment, gym)
    )
    val foldingChair = ItemToAdd(
      uuid = UUID.fromString("5821EA9E-DB8D-4DC6-AAD0-A26C50F85AC1"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Folding Chair",
      namePlural = "Folding Chairs",
      cft = 5,
      imageName = "folding-chair",
      alternateNames = listOf("Foldable Chair", "Camping Chair"),
      families = listOf(chairs, attic, garage, closet, shed, deck)
    )
    val foldingTable = ItemToAdd(
      uuid = UUID.fromString("BE6FD801-8FEA-483D-AAA1-330800C0695A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Folding Table",
      namePlural = "Folding Tables",
      cft = 12,
      imageName = "folding-table",
      alternateNames = listOf("Foldable Table"),
      families = listOf(tables, closet, attic, garage, deck)
    )
    val foldingWall = ItemToAdd(
      uuid = UUID.fromString("2AF8621A-29AA-45FA-A49E-9E3ABC227DDE"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Folding Wall",
      namePlural = "Folding Walls",
      cft = 8,
      imageName = "folding-wall",
      alternateNames = listOf("Privacy Partition", "Divider")
    )
    val footboard = ItemToAdd(
      uuid = UUID.fromString("49B3198C-787D-482C-B87E-B2BB16BC9832"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Footboard",
      namePlural = "Footboards",
      cft = 12,
      imageName = "footboard",
      families = listOf(bedFrames, bedroom)
    )
    val foosballTable = ItemToAdd(
      uuid = UUID.fromString("9A6D0CD1-54DC-4D68-8825-84C6A5806270"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Foosball Table",
      namePlural = "Foosball Tables",
      cft = 30,
      imageName = "foosball-table",
      families = listOf(tables, entertainmentRoom)
    )
    val freezer = ItemToAdd(
      uuid = UUID.fromString("856FE5A6-C6D4-4BBF-B62E-CCDB139E1115"),
      category = ItemCategory.OTHER,
      nameSingular = "Freezer",
      namePlural = "Freezers",
      cft = 42,
      imageName = "freezer",
      families = listOf(garage, kitchen)
    )
    val futon = ItemToAdd(
      uuid = UUID.fromString("5D9B89BE-34A6-488C-90F8-7C0ADE7212AE"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Futon Sofa",
      namePlural = "Futons Sofa",
      cft = 32,
      imageName = "futon",
      alternateNames = listOf("Folding Mattress Sofa", "Convertible Sofa", "Daybed"),
      families = listOf(sofas, mattresses, office, bedroom, livingRoom)
    )
    val gameConsole = ItemToAdd(
      uuid = UUID.fromString("71567AE6-1846-4F52-923B-346534582B66"),
      category = ItemCategory.OTHER,
      nameSingular = "Game Console",
      namePlural = "Game Consoles",
      cft = 2,
      imageName = "game-console",
      alternateNames = listOf("Video Game Console"),
      families = listOf(tvAndEntertainment, entertainmentRoom)
    )
    val garbageCan = ItemToAdd(
      uuid = UUID.fromString("B0717F98-CF15-42A9-9D5D-1A201F804F5C"),
      category = ItemCategory.OTHER,
      nameSingular = "Garbage Can",
      namePlural = "Garbage Cans",
      cft = 4,
      imageName = "garbage-can",
      alternateNames = listOf("Trash Can", "Garbage Bin"),
      families = listOf(kitchen)
    )
    val gardenGnome = ItemToAdd(
      uuid = UUID.fromString("5C1CDEC3-9D45-4167-9C10-E99C7A549539"),
      category = ItemCategory.OTHER,
      nameSingular = "Garden Gnome",
      namePlural = "Garden Gnomes",
      cft = 1,
      imageName = "garden-gnome",
      families = listOf(yard, shed)
    )
    val gardenTools = ItemToAdd(
      uuid = UUID.fromString("B0DEC29F-7FD0-4103-8EA4-9D6629E33D60"),
      category = ItemCategory.OTHER,
      nameSingular = "Garden Tool",
      namePlural = "Garden Tools",
      cft = 4,
      imageName = "garden-tool",
      families = listOf(yard, shed, garage)
    )
    val golfBag = ItemToAdd(
      uuid = UUID.fromString("C92D69FB-8168-4E0F-A256-0252DE704624"),
      category = ItemCategory.OTHER,
      nameSingular = "Golf Bag",
      namePlural = "Golf Bags",
      cft = 6,
      imageName = "golf-bag",
      families = listOf(closet, attic, garage)
    )
    val gong = ItemToAdd(
      uuid = UUID.fromString("2982E6BF-8BCD-4ED2-B557-F0B022233A22"),
      category = ItemCategory.OTHER,
      nameSingular = "Gong",
      namePlural = "Gongs",
      cft = 5,
      imageName = "gong",
      families = listOf(music)
    )
    val grandPiano = ItemToAdd(
      uuid = UUID.fromString("F3962381-86C1-4DA6-8A2D-010B170C2761"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Grand Piano",
      namePlural = "Grand Pianos",
      cft = 128,
      imageName = "baby-grand-piano",
      families = listOf(music),
      isPotentiallyOversized = true
    )
    val grandfatherClock = ItemToAdd(
      uuid = UUID.fromString("779A85E3-6D22-4003-973A-4205E2175B7A"),
      category = ItemCategory.OTHER,
      nameSingular = "Grandfather Clock",
      namePlural = "Grandfather Clocks",
      cft = 32,
      imageName = "grandfather-clock"
    )
    val guitar = ItemToAdd(
      uuid = UUID.fromString("8B380F8D-38B3-4627-96AD-75E4C4700A47"),
      category = ItemCategory.OTHER,
      nameSingular = "Guitar",
      namePlural = "Guitars",
      cft = 5,
      imageName = "guitar",
      families = listOf(music)
    )
    val gunSafe = ItemToAdd(
      uuid = UUID.fromString("CCB40966-2D25-4C43-87C0-E466E6837DF8"),
      category = ItemCategory.OTHER,
      nameSingular = "Gun Safe",
      namePlural = "Gun Safes",
      cft = 40,
      imageName = "gun-safe"
    )
    val halloweenDecorations = ItemToAdd(
      uuid = UUID.fromString("BE13057F-25DE-4910-97E0-BC247E4B7862"),
      category = ItemCategory.OTHER,
      nameSingular = "Halloween Decoration",
      namePlural = "Halloween Decorations",
      cft = 12,
      imageName = "halloween-decorations",
      families = listOf(garage, shed, attic)
    )
    val hallTable = ItemToAdd(
      uuid = UUID.fromString("28E5A8B1-C364-4E05-A6B4-522A69BF6F16"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Hall Table",
      namePlural = "Hall Tables",
      cft = 24,
      imageName = "hall-table",
      families = listOf(tables, hallway)
    )
    val hamper = ItemToAdd(
      uuid = UUID.fromString("7E477325-0683-4A9B-A97E-64F4F9BF8E98"),
      category = ItemCategory.OTHER,
      nameSingular = "Hamper",
      namePlural = "Hampers",
      cft = 8,
      imageName = "hamper",
      families = listOf(bins, bedroom, laundryRoom)
    )
    val headboard = ItemToAdd(
      uuid = UUID.fromString("4A1D4332-BE22-4A52-98AD-39657EBED668"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Headboard",
      namePlural = "Headboards",
      cft = 16,
      imageName = "headboard",
      families = listOf(bedFrames, bedroom)
    )
    val helmet = ItemToAdd(
      uuid = UUID.fromString("A0B00947-4154-4CDD-8880-D57A18C14DDE"),
      category = ItemCategory.OTHER,
      nameSingular = "Helmet",
      namePlural = "Helmets",
      cft = 2,
      imageName = "helmet",
      families = listOf(exerciseEquipment)
    )
    val highChair = ItemToAdd(
      uuid = UUID.fromString("D04B4442-967C-4EFC-9960-37794566530D"),
      category = ItemCategory.FURNITURE,
      nameSingular = "High Chair",
      namePlural = "High Chairs",
      cft = 6,
      imageName = "high-chair",
      families = listOf(chairs, kitchen, closet)
    )
    val hockeyStick = ItemToAdd(
      uuid = UUID.fromString("D7BCC75C-1653-4261-BE42-EF13C485069E"),
      category = ItemCategory.OTHER,
      nameSingular = "Hockey Stick",
      namePlural = "Hockey sticks",
      cft = 2,
      imageName = "hockey-stick",
      families = listOf(sports, closet, shed, yard, garage)
    )
    val hoseAndReel = ItemToAdd(
      uuid = UUID.fromString("6BCA9EA1-5CA7-4A86-B803-937E2014EF8B"),
      category = ItemCategory.OTHER,
      nameSingular = "Hose And Reel",
      namePlural = "Hose And Reels",
      cft = 8,
      imageName = "hose-and-reel",
      families = listOf(yard, garage, shed)
    )
    val hulaHoop = ItemToAdd(
      uuid = UUID.fromString("AE682F76-BE76-4887-9EF7-EE6207FF6CDD"),
      category = ItemCategory.OTHER,
      nameSingular = "Hula Hoop",
      namePlural = "Hula Hoops",
      cft = 2,
      imageName = "hula-hoop"
    )
    val humidifier = ItemToAdd(
      uuid = UUID.fromString("6AC1900C-897C-442A-9D20-594CA9ADE8C4"),
      category = ItemCategory.OTHER,
      nameSingular = "Humidifier",
      namePlural = "Humidifiers",
      cft = 3,
      imageName = "humidifier"
    )
    val insectCatchingNet = ItemToAdd(
      uuid = UUID.fromString("EC2748C3-7F0E-4C7A-8309-0710A6ED8E2F"),
      category = ItemCategory.OTHER,
      nameSingular = "Insect Catching Net",
      namePlural = "Insect Catching Nets",
      cft = 2,
      imageName = "insect-net",
      families = listOf(shed, yard)
    )
    val instantPot = ItemToAdd(
      uuid = UUID.fromString("C6DF6558-37E9-4F44-866E-B3447D73E9ED"),
      category = ItemCategory.OTHER,
      nameSingular = "Instant Pot",
      namePlural = "Instant Pots",
      cft = 3,
      imageName = "instant-pot",
      alternateNames = listOf("Rice Cooker", "Pressure Cooker", "Crock Pot", "Slow Cooker"),
      families = listOf(kitchen)
    )
    val iron = ItemToAdd(
      uuid = UUID.fromString("6B76406D-1403-4F90-A0C6-EFD4A2A73EE7"),
      category = ItemCategory.OTHER,
      nameSingular = "Iron",
      namePlural = "Irons",
      cft = 2,
      imageName = "iron",
      families = listOf(closet)
    )
    val ironingBoard = ItemToAdd(
      uuid = UUID.fromString("886BFBB7-D59D-4C32-A691-22F83A1BBF38"),
      category = ItemCategory.OTHER,
      nameSingular = "Ironing Board",
      namePlural = "Ironing Boards",
      cft = 5,
      imageName = "ironing-board",
      families = listOf(closet)
    )
    val jewelryBox = ItemToAdd(
      uuid = UUID.fromString("D7E13F7A-D4C6-4B6E-96C5-4C9E80F917AF"),
      category = ItemCategory.OTHER,
      nameSingular = "Jewelry Box",
      namePlural = "Jewelry Boxes",
      cft = 2,
      imageName = "jewelry-box",
      families = listOf(bedroom)
    )
    val jukeBox = ItemToAdd(
      uuid = UUID.fromString("1ceb6a25-d1e6-4650-86c3-2d2dd3899d93"),
      category = ItemCategory.OTHER,
      nameSingular = "Juke Box",
      namePlural = "Juke Boxes",
      cft = 8,
      imageName = "juke-box",
      families = listOf(entertainmentRoom, music)
    )
    val kayak = ItemToAdd(
      uuid = UUID.fromString("05ad57f0-006d-4393-b140-705db22891f7"),
      category = ItemCategory.OTHER,
      nameSingular = "Kayak",
      namePlural = "Kayaks",
      cft = 36,
      imageName = "kayak",
      families = listOf(garage, sports, camping)
    )
    val keyboardPiano = ItemToAdd(
      uuid = UUID.fromString("C8AC9B18-8922-4BF5-AE4E-6ABE7885B9C1"),
      category = ItemCategory.OTHER,
      nameSingular = "Keyboard Piano",
      namePlural = "Keyboard Piano",
      cft = 10,
      imageName = "keyboard-piano",
      families = listOf(music)
    )
    val kidsChair = ItemToAdd(
      uuid = UUID.fromString("8C95686C-287E-494C-94A9-55FDD5C2980C"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Kids Chair",
      namePlural = "Kids Chairs",
      cft = 4,
      imageName = "kids-chair",
      families = listOf(chairs, kidsRoom)
    )
    val kidsSandBox = ItemToAdd(
      uuid = UUID.fromString("A009476B-9A77-4617-97A2-B576B33F561D"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Kids Sand Box",
      namePlural = "Kids Sand Boxes",
      cft = 32,
      imageName = "kids-sand-box",
      families = listOf(yard)
    )
    val kidsTable = ItemToAdd(
      uuid = UUID.fromString("D9C3C8AA-4F64-4F2E-B781-AA515AD0878D"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Kids Table",
      namePlural = "Kids Tables",
      cft = 10,
      imageName = "kids-table",
      families = listOf(tables, kidsRoom)
    )
    val kingBedFrame = ItemToAdd(
      uuid = UUID.fromString("9E40A6AE-D2B3-43EC-B71F-17CECB921543"),
      category = ItemCategory.FURNITURE,
      nameSingular = "King Bed Frame",
      namePlural = "King Bed Frames",
      cft = 42,
      alternateNames = listOf("California King Bed"),
      imageName = "bed-frame",
      families = listOf(bedFrames, bedroom)
    )
    val kingBoxSpring = ItemToAdd(
      uuid = UUID.fromString("947A2AA3-9C1C-4C88-8909-0286BA4C39EF"),
      category = ItemCategory.FURNITURE,
      nameSingular = "King Box Spring",
      namePlural = "King Box Springs",
      cft = 64,
      alternateNames = listOf("California King Box Spring", "King Bed Box Spring"),
      imageName = "box-spring",
      families = listOf(boxSprings, bedroom)
    )
    val kingMattress = ItemToAdd(
      uuid = UUID.fromString("83EBFEEF-3768-4328-9B5E-09364356C7E1"),
      category = ItemCategory.FURNITURE,
      nameSingular = "King Mattress",
      namePlural = "King Mattresses",
      cft = 64,
      alternateNames = listOf("California King Mattress", "King Bed Mattress"),
      imageName = "mattress",
      families = listOf(mattresses, bedroom)
    )
    val kitchenCart = ItemToAdd(
      uuid = UUID.fromString("F8568F8A-FF68-4626-AEBB-6E53C0C94C9F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Kitchen Cart",
      namePlural = "Kitchen Carts",
      cft = 16,
      alternateNames = listOf("Kitchen Cart Island", "Rolling Tray"),
      imageName = "kitchen-cart-island",
      families = listOf(tables, kitchen)
    )
    val kitchenTable = ItemToAdd(
      uuid = UUID.fromString("74553867-A058-4BAB-87D6-FA590AA883AD"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Kitchen Table",
      namePlural = "Kitchen Tables",
      cft = 32,
      imageName = "kitchen-table",
      families = listOf(tables, kitchen)
    )
    val ladder = ItemToAdd(
      uuid = UUID.fromString("B727B94A-2C40-4E70-870A-2B71F6CAC220"),
      category = ItemCategory.OTHER,
      nameSingular = "Ladder",
      namePlural = "Ladders",
      cft = 12,
      imageName = "ladder",
      families = listOf(closet, attic, garage, shed)
    )
    val lampBox = ItemToAdd(
      uuid = UUID.fromString("243DB9DD-C970-4F69-9823-A3B85B5EC25A"),
      category = ItemCategory.BOX,
      nameSingular = "Lamp Box",
      namePlural = "Lamp Boxes",
      cft = 7,
      imageName = "box",
      families = listOf(boxes)
    )
    val lampShade = ItemToAdd(
      uuid = UUID.fromString("39C0D4B3-BCDB-4BE3-9AEC-933DF76B3AE1"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Lampshade",
      namePlural = "Lampshades",
      cft = 4,
      imageName = "bedside-lamp"
    )
    val largeAquarium = ItemToAdd(
      uuid = UUID.fromString("888CBED8-0E0C-497C-91CC-05F0601F58AE"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Aquarium",
      namePlural = "Large Aquariums",
      alternateNames = listOf("Large Fish Tank"),
      cft = 32,
      imageName = "small-aquarium"
    )
    val largeBox = ItemToAdd(
      uuid = UUID.fromString("1A841705-F8CD-423C-A154-0DC232D3C5C2"),
      category = ItemCategory.BOX,
      nameSingular = "Large Box",
      namePlural = "Large Boxes",
      cft = 7,
      imageName = "box",
      families = listOf(boxes)
    )
    val largeCabinet = ItemToAdd(
      uuid = UUID.fromString("D275F4EF-5517-4CEB-877C-7E4CB67E7600"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Large Cabinet",
      namePlural = "Large Cabinets",
      cft = 56,
      imageName = "cabinet",
      families = listOf(cabinets, diningRoom),
      isPotentiallyOversized = true
    )
    val largeDesk = ItemToAdd(
      uuid = UUID.fromString("30D0ADAF-E215-4543-8A68-1EC8CD5B58B3"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Large Desk",
      namePlural = "Large Desks",
      cft = 48,
      alternateNames = listOf("Office Table", "Office Desk"),
      imageName = "desk",
      families = listOf(tables, office),
      isPotentiallyOversized = true
    )
    val largeEntertainmentCenter = ItemToAdd(
      uuid = UUID.fromString("F23D07E8-2CE6-4DE8-B7A4-C081D3496730"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Large Entertainment Center",
      namePlural = "Large Entertainment Centers",
      cft = 52,
      alternateNames = listOf("Large Media Center"),
      imageName = "large-entertainment-center",
      families = listOf(tvAndEntertainment, drawers, entertainmentRoom),
      isPotentiallyOversized = true
    )
    val largeFramedPicture = ItemToAdd(
      uuid = UUID.fromString("11AE6727-E39F-4D29-ADD9-438045EE3F26"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Framed Picture",
      namePlural = "Large Framed Pictures",
      cft = 8,
      alternateNames = listOf("Large Painting", "Large Framed Art"),
      imageName = "large-framed-picture",
      families = listOf(art)
    )
    val lawnChair = ItemToAdd(
      uuid = UUID.fromString("1FA7434A-C358-499F-8ADB-4C949FD03641"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Lawn Chair",
      namePlural = "Lawn Chairs",
      cft = 7,
      imageName = "lawn-chair",
      families = listOf(chairs, yard)
    )
    val extraLargeFramedPicture = ItemToAdd(
      uuid = UUID.fromString("6B3001F3-82D1-4D38-A92E-29A088361B18"),
      category = ItemCategory.OTHER,
      nameSingular = "Extra Large Framed Picture",
      namePlural = "Extra Large Framed Pictures",
      cft = 16,
      alternateNames = listOf("Extra Large Painting", "Extra Large Framed Art"),
      imageName = "large-framed-picture",
      families = listOf(art)
    )
    val largeKidsToy = ItemToAdd(
      uuid = UUID.fromString("65F9EFC1-B1C0-4E49-A8BA-EF6EECFB5279"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Kids Toy",
      namePlural = "Large Kids Toys",
      cft = 10,
      alternateNames = listOf("Large Dollhouse", "Ride-In Toy Car", "Toy Kitchen Set"),
      imageName = "dollhouse",
      families = listOf(kidsRoom, yard)
    )
    val largeMirror = ItemToAdd(
      uuid = UUID.fromString("AFA95CD3-DA91-4332-98B1-2175B2BA2C01"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Large Mirror",
      namePlural = "Large Mirrors",
      cft = 7,
      imageName = "large-framed-picture",
      isPotentiallyOversized = true,
      families = listOf(bedroom, livingRoom, hallway)
    )
    val largeRange = ItemToAdd(
      uuid = UUID.fromString("5EBF2E52-7A21-4FA7-B925-01807473ED13"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Range (36\" Wide)",
      namePlural = "Large Ranges (36\" Wide)",
      cft = 96,
      alternateNames = listOf("Large Stove", "Large Oven"),
      imageName = "small-range",
      families = listOf(kitchen)
    )
    val largeTV = ItemToAdd(
      uuid = UUID.fromString("B83F9A85-2E0F-4BD7-91B7-848A7C0D908B"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Television",
      namePlural = "Large Televisions",
      cft = 20,
      alternateNames = listOf("Large TV"),
      imageName = "television",
      families = listOf(tvAndEntertainment, entertainmentRoom, bedroom)
    )
    val laundryBasket = ItemToAdd(
      uuid = UUID.fromString("9A73FF83-E702-4556-9F01-D608B9047495"),
      category = ItemCategory.OTHER,
      nameSingular = "Laundry Basket",
      namePlural = "Laundry Baskets",
      cft = 6,
      alternateNames = listOf("Plastic Basket", "Clothing Basket"),
      imageName = "laundry-basket",
      families = listOf(bins, bedroom, laundryRoom)
    )
    val laundryRack = ItemToAdd(
      uuid = UUID.fromString("BEE398C5-1A93-4712-BE14-696015723966"),
      category = ItemCategory.OTHER,
      nameSingular = "Laundry Rack",
      namePlural = "Laundry Racks",
      cft = 8,
      alternateNames = listOf("Drying rack"),
      imageName = "drying-rack",
      families = listOf(laundryRoom, yard, deck)
    )
    val lawnMower = ItemToAdd(
      uuid = UUID.fromString("078EA6E1-3521-4DA0-AC84-C193FDE4170D"),
      category = ItemCategory.OTHER,
      nameSingular = "Lawn Mower",
      namePlural = "Lawn Mowers",
      cft = 18,
      imageName = "lawn-mower",
      families = listOf(garage, yard, shed)
    )
    val leafBlower = ItemToAdd(
      uuid = UUID.fromString("50dfe004-94a9-4666-98d8-3376c96c85ea"),
      category = ItemCategory.OTHER,
      nameSingular = "Leaf Blower",
      namePlural = "Leaf Blowers",
      cft = 8,
      imageName = "leaf-blower",
      families = listOf(garage, yard, shed)
    )
    val laptop = ItemToAdd(
      uuid = UUID.fromString("371CD878-EEEC-4C50-AD6E-3A0FB6E0286B"),
      category = ItemCategory.OTHER,
      nameSingular = "Laptop",
      namePlural = "Laptops",
      cft = 1,
      alternateNames = listOf("Macbook"),
      imageName = "laptop",
      families = listOf(bedroom, office)
    )
    val leatherBasket = ItemToAdd(
      uuid = UUID.fromString("28AA1BD7-2813-4531-97EE-87E7BF6AFA87"),
      category = ItemCategory.OTHER,
      nameSingular = "Leather Basket",
      namePlural = "Leather Baskets",
      cft = 8,
      imageName = "wicker-basket",
      families = listOf(bins)
    )
    val leaningShelf = ItemToAdd(
      uuid = UUID.fromString("CF54C02E-6217-480F-B5D8-B46C50BFA854"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Leaning Shelf",
      namePlural = "Leaning Shelves",
      cft = 20,
      imageName = "leaning-shelf",
      families = listOf(shelves, livingRoom)
    )
    val linens = ItemToAdd(
      uuid = UUID.fromString("5FB168FB-48BE-457D-932A-33F750A958F2"),
      category = ItemCategory.OTHER,
      nameSingular = "Linens",
      namePlural = "Linens",
      cft = 4,
      alternateNames = listOf("Linens (In Packaging)", "Bedding"),
      imageName = "linens",
      families = listOf(closet, laundryRoom)
    )
    val longboard = ItemToAdd(
      uuid = UUID.fromString("3F6DF3DF-2F16-4398-9BA0-2107A0E4484C"),
      category = ItemCategory.OTHER,
      nameSingular = "Longboard",
      namePlural = "Longboards",
      cft = 4,
      imageName = "longboard",
      families = listOf(sports, garage)
    )
    val mannequin = ItemToAdd(
      uuid = UUID.fromString("D86BED1A-B6F4-440E-85F4-26E80BD3AC47"),
      category = ItemCategory.OTHER,
      nameSingular = "Mannequin",
      namePlural = "Mannequins",
      cft = 8,
      alternateNames = listOf("Dress Form"),
      imageName = "mannequin"
    )
    val massageChair = ItemToAdd(
      uuid = UUID.fromString("71483ac6-8530-44ff-8c2c-80b2e4d50382"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Massage Chair",
      namePlural = "Massage Chairs",
      cft = 24,
      imageName = "massage-chair",
      families = listOf(chairs)
    )
    val massageTable = ItemToAdd(
      uuid = UUID.fromString("859E7B63-E28D-4683-B8B6-07C7690A4473"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Massage Table",
      namePlural = "Massage Tables",
      cft = 15,
      imageName = "massage-table",
      families = listOf(tables)
    )
    val mat = ItemToAdd(
      uuid = UUID.fromString("2D6751D7-E4C4-4A91-9BC2-DB3F1576E572"),
      category = ItemCategory.OTHER,
      nameSingular = "Mat",
      namePlural = "Mats",
      cft = 3,
      imageName = "rug",
      families = listOf(deck, yard, hallway)
    )
    val mattressPad = ItemToAdd(
      uuid = UUID.fromString("3c2bf293-765f-4070-8c80-5ff536d0542d"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Mattress Pad",
      namePlural = "Mattress Pads",
      cft = 8,
      alternateNames = listOf("Memory Foam Topper", "Mattress Topper", "Bed Pad", "Bed Foam Pad"),
      imageName = "memory-foam-topper",
      families = listOf(mattresses, bedroom)
    )
    val medicineBall = ItemToAdd(
      uuid = UUID.fromString("3CE127F7-651C-4CCA-952F-999EFA733193"),
      category = ItemCategory.OTHER,
      nameSingular = "Medicine Ball",
      namePlural = "Medicine Balls",
      cft = 2,
      imageName = "medicine-ball",
      families = listOf(exerciseEquipment, gym)
    )
    val mediumBox = ItemToAdd(
      uuid = UUID.fromString("53BB899C-1611-4B06-BE10-1B01F66AF702"),
      category = ItemCategory.BOX,
      nameSingular = "Medium Box",
      namePlural = "Medium Boxes",
      cft = 4,
      imageName = "box",
      families = listOf(boxes)
    )
    val mediumCabinet = ItemToAdd(
      uuid = UUID.fromString("14F04796-26DF-41A7-AC17-2288D2A28FAE"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Medium Cabinet",
      namePlural = "Medium Cabinets",
      cft = 32,
      imageName = "cabinet",
      families = listOf(diningRoom, drawers)
    )
    val mediumFramedPicture = ItemToAdd(
      uuid = UUID.fromString("6C13D03B-C954-4F9A-A2FB-9DC2A072F44D"),
      category = ItemCategory.OTHER,
      nameSingular = "Medium Framed Picture",
      namePlural = "Medium Framed Pictures",
      cft = 4,
      alternateNames = listOf("Painting", "Medium Framed Art"),
      imageName = "large-framed-picture",
      families = listOf(art)
    )
    val mediumRange = ItemToAdd(
      uuid = UUID.fromString("7BA41D50-89E6-4DB3-B4A8-16FFDB4BB05B"),
      category = ItemCategory.OTHER,
      nameSingular = "Medium Range (30\" Wide)",
      namePlural = "Medium Ranges (30\" Wide)",
      cft = 72,
      alternateNames = listOf("Medium Stove", "Medium Oven"),
      imageName = "small-range",
      families = listOf(kitchen)
    )
    val metalBedFrame = ItemToAdd(
      uuid = UUID.fromString("8B7AA2B0-28E9-46DB-A826-B608151DCF30"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Metal Bed Frame",
      namePlural = "Metal Bed Frames",
      cft = 6,
      imageName = "metal-bed-frame",
      families = listOf(bedFrames)
    )
    val metalPoles = ItemToAdd(
      uuid = UUID.fromString("C1C63D4C-1636-4D29-811A-FCCD8936EA07"),
      category = ItemCategory.OTHER,
      nameSingular = "Metal Poles",
      namePlural = "Metal Poles",
      cft = 3,
      imageName = "metal-poles"
    )
    val metalRack = ItemToAdd(
      uuid = UUID.fromString("73CB21CE-43A8-4E97-AF4A-E4CBA7E88A83"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Metal Rack",
      namePlural = "Metal Racks",
      cft = 16,
      alternateNames = listOf("Storage Rack", "Metal Shelf", "Plastic Rack"),
      imageName = "metal-rack",
      families = listOf(garage, shed)
    )
    val microwave = ItemToAdd(
      uuid = UUID.fromString("C304CB46-5675-45B5-9F44-79FEE2C09BB9"),
      category = ItemCategory.OTHER,
      nameSingular = "Microwave",
      namePlural = "Microwaves",
      cft = 5,
      imageName = "microwave",
      families = listOf(kitchen)
    )
    val miniBar = ItemToAdd(
      uuid = UUID.fromString("4103C3B2-38F1-4ADB-B9E9-95FDBFFA62C3"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Mini Bar",
      namePlural = "Mini Bars",
      cft = 38,
      imageName = "mini-bar",
      families = listOf(diningRoom, entertainmentRoom)
    )
    val miniFridge = ItemToAdd(
      uuid = UUID.fromString("FD711A5E-CF18-488C-9B55-FAC41F0C9AC8"),
      category = ItemCategory.OTHER,
      nameSingular = "Mini Fridge",
      namePlural = "Mini Fridges",
      cft = 12,
      imageName = "mini-fridge"
    )
    val mirrorOrArtBox = ItemToAdd(
      uuid = UUID.fromString("09362B64-B4A9-4221-AEE1-E9C5E4BAA6D1"),
      category = ItemCategory.BOX,
      nameSingular = "Mirror/Picture Box",
      namePlural = "Mirror/Picture Boxes",
      cft = 3,
      imageName = "box",
      alternateNames = listOf("Art Box", "Art Pack", "Mirror Pack", "Picture Pack"),
      families = listOf(boxes, art)
    )
    val monitor = ItemToAdd(
      uuid = UUID.fromString("4B10E20C-213B-4F02-888C-48D6D06003EE"),
      category = ItemCategory.OTHER,
      nameSingular = "Monitor",
      namePlural = "Monitors",
      cft = 8,
      imageName = "television",
      alternateNames = listOf("Computer Monitor", "LCD Monitor", "Computer Display", "iMac", "Computer Screen"),
      families = listOf(office)
    )
    val moped = ItemToAdd(
      uuid = UUID.fromString("4A9B9856-E6DF-4E8B-BECC-BDA00E188964"),
      category = ItemCategory.OTHER,
      nameSingular = "Moped",
      namePlural = "Mopeds",
      cft = 35,
      imageName = "moped",
      families = listOf(garage, shed)
    )
    val mosesBasket = ItemToAdd(
      uuid = UUID.fromString("D50F5D60-A30D-4D96-82D5-30FDEFC4076F"),
      category = ItemCategory.OTHER,
      nameSingular = "Moses Basket",
      namePlural = "Moses Baskets",
      cft = 6,
      imageName = "moses-basket",
      families = listOf(kidsRoom)
    )
    val officeChair = ItemToAdd(
      uuid = UUID.fromString("2A74BFC2-F1BF-4E6C-BF3F-EE2D137E652F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Office Chair",
      namePlural = "Office chairs",
      cft = 10,
      imageName = "office-chair",
      families = listOf(chairs, office)
    )
    val ottoman = ItemToAdd(
      uuid = UUID.fromString("2EDF714D-38D5-41A8-8F72-DCA253E533B6"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Ottoman",
      namePlural = "Ottomans",
      cft = 16,
      alternateNames = listOf("Footstool", "Poof"),
      imageName = "ottoman",
      families = listOf(livingRoom, entertainmentRoom)
    )
    val outdoorFirePit = ItemToAdd(
      uuid = UUID.fromString("1BA0F138-4CCC-4500-9C98-12D91D51B1F0"),
      category = ItemCategory.OTHER,
      nameSingular = "Outdoor Fire Pit",
      namePlural = "Outdoor Fire Pits",
      cft = 20,
      alternateNames = listOf("Fire Pit"),
      imageName = "outdoor-fire-pit",
      families = listOf(yard, deck)
    )
    val outdoorHeater = ItemToAdd(
      uuid = UUID.fromString("155caac4-4af2-4f7b-8c01-33f586624d54"),
      category = ItemCategory.OTHER,
      nameSingular = "Outdoor Heater",
      namePlural = "Outdoor Heaters",
      cft = 24,
      alternateNames = listOf("Patio Heater"),
      imageName = "outdoor-heater",
      families = listOf(yard, deck, shed)
    )
    val outdoorMetalChair = ItemToAdd(
      uuid = UUID.fromString("E66CA548-D9CA-4EA0-A1F8-96D3B83A4465"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Outdoor Chair",
      namePlural = "Outdoor Chairs",
      cft = 12,
      alternateNames = listOf("Patio Chair", "Garden Chair"),
      imageName = "outdoor-metal-chair",
      families = listOf(chairs, deck, yard)
    )
    val outdoorUmbrella = ItemToAdd(
      uuid = UUID.fromString("FB11A515-F8AC-41CA-9242-3E82C2092CBE"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Outdoor Umbrella",
      namePlural = "Outdoor Umbrellas",
      cft = 10,
      alternateNames = listOf("Patio Umbrella", "Sun Umbrella"),
      imageName = "outdoor-umbrella",
      isPotentiallyOversized = true,
      families = listOf(deck, yard)
    )
    val overstuffedChair = ItemToAdd(
      uuid = UUID.fromString("94001E26-5A4F-4184-92B1-6B0BFCE86EEC"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Overstuffed Chair",
      namePlural = "Overstuffed Chairs",
      cft = 50,
      imageName = "overstuffed-chair",
      alternateNames = listOf(
        "1 Cushion Couch",
        "1 Seat Couch",
        "1 Seat Sofa",
        "One Cushion Couch",
        "One Seat Couch",
        "One Cushion Sofa",
        "One Seat Sofa",
        "Sofa (1 Cushion)"
      ),
      families = listOf(chairs, sofas, livingRoom, entertainmentRoom)
    )
    val paddle = ItemToAdd(
      uuid = UUID.fromString("A9B19AF0-AEED-48EE-8288-832CB96E863E"),
      category = ItemCategory.OTHER,
      nameSingular = "Paddle",
      namePlural = "Paddles",
      cft = 4,
      imageName = "paddle",
      families = listOf(sports, shed, garage, camping)
    )
    val paintBucket = ItemToAdd(
      uuid = UUID.fromString("D85F8FE7-8773-46CA-8F89-72BC46782FDC"),
      category = ItemCategory.OTHER,
      nameSingular = "Paint Bucket",
      namePlural = "Paint Buckets",
      cft = 2,
      imageName = "paint-bucket",
      families = listOf(yard, shed, garage, attic)
    )
    val paperShredder = ItemToAdd(
      uuid = UUID.fromString("E8AC6424-4101-4D3F-AA08-A31C652A5325"),
      category = ItemCategory.OTHER,
      nameSingular = "Paper Shredder",
      namePlural = "Paper Shredders",
      cft = 3,
      imageName = "paper-shredder",
      families = listOf(office)
    )
    val paperTube = ItemToAdd(
      uuid = UUID.fromString("74AD504C-3C71-4460-9942-69E0B66B8B5E"),
      category = ItemCategory.OTHER,
      nameSingular = "Paper Tube",
      namePlural = "Paper Tubes",
      cft = 6,
      imageName = "paper-tube"
    )
    val patioTable = ItemToAdd(
      uuid = UUID.fromString("D2A6A86B-6F17-4560-8CCF-DC3A08EBD8A8"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Patio Table",
      namePlural = "Patio Tables",
      cft = 32,
      imageName = "patio-table",
      families = listOf(tables, deck, yard)
    )
    val pedestalFan = ItemToAdd(
      uuid = UUID.fromString("0C116019-8F08-482E-9916-001F12281123"),
      category = ItemCategory.OTHER,
      nameSingular = "Pedestal Fan",
      namePlural = "Pedestal Fans",
      cft = 8,
      imageName = "pedestal-fan"
    )
    val petCarrier = ItemToAdd(
      uuid = UUID.fromString("26B64715-02D5-41CA-AA04-4B46E4C3638E"),
      category = ItemCategory.OTHER,
      nameSingular = "Pet Carrier",
      namePlural = "Pet Carriers",
      cft = 6,
      imageName = "pet-carrier",
      alternateNames = listOf("Small Kennel")
    )
    val petCrate = ItemToAdd(
      uuid = UUID.fromString("2671F4BF-5E0A-4700-9BAE-09522F48D053"),
      category = ItemCategory.OTHER,
      nameSingular = "Pet Crate",
      namePlural = "Pet Crates",
      cft = 24,
      imageName = "pet-crate",
      alternateNames = listOf("Dog Crate", "Cat Crate", "Kennel")
    )
    val petStairs = ItemToAdd(
      uuid = UUID.fromString("40D92745-6457-4CCA-B596-021694B50BA8"),
      category = ItemCategory.OTHER,
      nameSingular = "Pet Stairs",
      namePlural = "Pet Stairs",
      cft = 6,
      imageName = "pet-stairs"
    )
    val pianoBench = ItemToAdd(
      uuid = UUID.fromString("8C1846B1-A623-4753-91B8-4D28BB5A6E53"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Piano Bench",
      namePlural = "Piano Benches",
      cft = 8,
      imageName = "piano-bench",
      families = listOf(music, livingRoom)
    )
    val picnicTable = ItemToAdd(
      uuid = UUID.fromString("79D8ACFC-FF58-4489-834F-907AA6DCD984"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Picnic Table",
      namePlural = "Picnic Tables",
      cft = 40,
      imageName = "picnic-table",
      families = listOf(tables, yard, deck)
    )
    val pinballMachine = ItemToAdd(
      uuid = UUID.fromString("b636f5cb-1f7b-490f-8609-c9bcb4d4893e"),
      category = ItemCategory.OTHER,
      nameSingular = "Pinball Machine",
      namePlural = "Pinball Machines",
      cft = 32,
      imageName = "pinball-machine",
      families = listOf(tables, entertainmentRoom)
    )
    val pingPongTable = ItemToAdd(
      uuid = UUID.fromString("63E82C34-4268-4182-AA49-7E352A5F7169"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Ping Pong Table",
      namePlural = "Ping Pong Tables",
      cft = 48,
      alternateNames = listOf("Table Tennis"),
      imageName = "ping-pong-table",
      families = listOf(tables, entertainmentRoom)
    )
    val plant = ItemToAdd(
      uuid = UUID.fromString("E34168B1-DAC3-43E0-A327-57FEF86A5B79"),
      category = ItemCategory.OTHER,
      nameSingular = "Plant",
      namePlural = "Plants",
      cft = 5,
      imageName = "plant",
      families = listOf(art, yard, deck, hallway, livingRoom)
    )
    val plasticBinSmall = ItemToAdd(
      uuid = UUID.fromString("82209F90-022A-4CA9-A9C2-71A1F3CAD50F"),
      category = ItemCategory.BOX,
      nameSingular = "Small Plastic Bin",
      namePlural = "Small Plastic Bins",
      cft = 2,
      imageName = "plastic-bin",
      alternateNames = listOf("Small Recycling Bin"),
      families = listOf(bins)
    )
    val plasticBinMedium = ItemToAdd(
      uuid = UUID.fromString("B6C3801E-5A99-452D-BE26-3716E748913C"),
      category = ItemCategory.BOX,
      nameSingular = "Medium Plastic Bin",
      namePlural = "Medium Plastic Bins",
      cft = 4,
      imageName = "plastic-bin",
      alternateNames = listOf("Medium Recycling Bin"),
      families = listOf(bins)
    )
    val plasticBinLarge = ItemToAdd(
      uuid = UUID.fromString("D700B0F2-E3AF-4439-B212-FAB45D82E5BC"),
      category = ItemCategory.BOX,
      nameSingular = "Large Plastic Bin",
      namePlural = "Large Plastic Bins",
      cft = 6,
      imageName = "plastic-bin",
      alternateNames = listOf("Large Recycling Bin"),
      families = listOf(bins)
    )
    val plasticChair = ItemToAdd(
      uuid = UUID.fromString("4F487FE1-7999-43B2-8DD0-5D8F9EFFBD53"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Plastic Chair",
      namePlural = "Plastic Chairs",
      cft = 10,
      imageName = "plastic-chair",
      families = listOf(chairs)
    )
    val plasticCrate = ItemToAdd(
      uuid = UUID.fromString("F776339E-BFE6-4669-83E8-7CC7BE7651EF"),
      category = ItemCategory.BOX,
      nameSingular = "Plastic Crate",
      namePlural = "Plastic Crates",
      cft = 1,
      imageName = "plastic-crate",
      families = listOf(bins)
    )
    val plasticDrawer = ItemToAdd(
      uuid = UUID.fromString("4F6739CA-70D8-42AE-B957-A3FBBE86F581"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Plastic Drawers",
      namePlural = "Plastic Drawers",
      cft = 8,
      imageName = "plastic-drawers",
      families = listOf(drawers, kidsRoom)
    )
    val playard = ItemToAdd(
      uuid = UUID.fromString("71BA3043-A072-490E-944C-498256D1A7C8"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Playard",
      namePlural = "Playards",
      cft = 20,
      alternateNames = listOf("Pack 'N Play"),
      imageName = "playard",
      families = listOf(kidsRoom)
    )
    val pokerSet = ItemToAdd(
      uuid = UUID.fromString("0B018E3B-6BB4-4DE2-B754-55D137C6C7AE"),
      category = ItemCategory.OTHER,
      nameSingular = "Poker Set",
      namePlural = "Poker Sets",
      cft = 2,
      imageName = "poker-set"
    )
    val pokerTable = ItemToAdd(
      uuid = UUID.fromString("5C2C1747-C87C-4104-BEB8-1A52E9D9BAB0"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Poker Table",
      namePlural = "Poker Tables",
      cft = 32,
      imageName = "poker-table",
      families = listOf(tables)
    )
    val poolChair = ItemToAdd(
      uuid = UUID.fromString("4C815E80-1C54-4188-ABEC-141C7883C323"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Pool Chair",
      namePlural = "Pool Chairs",
      cft = 12,
      imageName = "pool-chair",
      families = listOf(chairs, yard)
    )
    val poolTable = ItemToAdd(
      uuid = UUID.fromString("FA71B5A1-D7DE-465B-95D4-0EDCBD9979BC"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Pool Table",
      namePlural = "Pool Tables",
      cft = 48,
      alternateNames = listOf("Billiards Table"),
      imageName = "pool-table",
      families = listOf(tables, entertainmentRoom)
    )
    val portableAc = ItemToAdd(
      uuid = UUID.fromString("AD2BC572-6355-4B18-B90B-FA8FA18C1F88"),
      category = ItemCategory.OTHER,
      nameSingular = "Portable A/C",
      namePlural = "Portable A/Cs",
      cft = 12,
      alternateNames = listOf("Mobile A/C", "Portable AC", "Portable Air Conditioner"),
      imageName = "portable-ac"
    )
    val portableClothesRack = ItemToAdd(
      uuid = UUID.fromString("D3137287-12C9-4717-9279-1120BE565F57"),
      category = ItemCategory.OTHER,
      nameSingular = "Clothes Rack",
      namePlural = "Clothes Racks",
      cft = 12,
      alternateNames = listOf("Clothing Rack"),
      imageName = "portable-clothes-rack",
      families = listOf(laundryRoom, yard, deck)
    )
    val portableGrill = ItemToAdd(
      uuid = UUID.fromString("1a7730c8-19a8-4e25-8628-6c96c4a6ec20"),
      category = ItemCategory.OTHER,
      nameSingular = "Portable Grill",
      namePlural = "Portable Grills",
      cft = 12,
      alternateNames = listOf("Portable BBQ", "Camping Grill"),
      imageName = "portable-grill",
      families = listOf(camping)
    )
    val portableStove = ItemToAdd(
      uuid = UUID.fromString("423A49E8-5F79-4090-BD04-D9AE6F5539AA"),
      category = ItemCategory.OTHER,
      nameSingular = "Portable Stove",
      namePlural = "Portable Stoves",
      cft = 2,
      alternateNames = listOf("Camp Stove"),
      imageName = "portable-stove",
      families = listOf(camping)
    )
    val poster = ItemToAdd(
      uuid = UUID.fromString("3C3A52DD-FAA5-479F-9F7F-4530DDF06879"),
      category = ItemCategory.OTHER,
      nameSingular = "Poster",
      namePlural = "Posters",
      cft = 4,
      imageName = "poster",
      families = listOf(art)
    )
    val powerTool = ItemToAdd(
      uuid = UUID.fromString("87A0CF27-3B97-4EF9-879E-AA7B3658188C"),
      category = ItemCategory.OTHER,
      nameSingular = "Power Tool",
      namePlural = "Power Tools",
      cft = 2,
      alternateNames = listOf("Nail Gun", "Jigsaw", "Saw", "Chainsaw", "Screwdriver"),
      imageName = "power-tools",
      families = listOf(workshop, closet, shed)
    )
    val printer = ItemToAdd(
      uuid = UUID.fromString("172881FE-8261-4A8F-B1FE-597023D725F1"),
      category = ItemCategory.OTHER,
      nameSingular = "Printer",
      namePlural = "Printers",
      cft = 8,
      imageName = "printer",
      families = listOf(office)
    )
    val printer3D = ItemToAdd(
      uuid = UUID.fromString("DA8F75A0-CD1F-4B63-9DBE-B897C7FF41CF"),
      category = ItemCategory.OTHER,
      nameSingular = "3D Printer",
      namePlural = "3D Printers",
      cft = 10,
      imageName = "printer",
      families = listOf(office, workshop)
    )
    val punchingBag = ItemToAdd(
      uuid = UUID.fromString("010dbbe1-56e8-4297-a569-02777b911a43"),
      category = ItemCategory.OTHER,
      nameSingular = "Punching Bag",
      namePlural = "Punching Bags",
      cft = 14,
      imageName = "punching-bag",
      families = listOf(gym, exerciseEquipment)
    )
    val purse = ItemToAdd(
      uuid = UUID.fromString("03F8F4D1-4689-4BB7-AE1C-F9C309EB7EDC"),
      category = ItemCategory.OTHER,
      nameSingular = "Purse",
      namePlural = "Purses",
      cft = 2,
      alternateNames = listOf("Handbag"),
      imageName = "purse"
    )
    val pushGolfCart = ItemToAdd(
      uuid = UUID.fromString("74C1E8E1-0A3C-46BB-8359-C6CC495050A3"),
      category = ItemCategory.OTHER,
      nameSingular = "Push Golf Cart",
      namePlural = "Push Golf Carts",
      cft = 8,
      imageName = "push-golf-cart",
      families = listOf(garage, shed, attic)
    )
    val queenBedFrame = ItemToAdd(
      uuid = UUID.fromString("823803BC-C90E-4669-8317-3308A33B56BF"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Queen Bed Frame",
      namePlural = "Queen Bed Frames",
      cft = 36,
      imageName = "bed-frame",
      families = listOf(bedFrames, bedroom)
    )
    val queenBoxSpring = ItemToAdd(
      uuid = UUID.fromString("BC3CEEA2-412B-4498-9E76-78B8B4DC105E"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Queen Box Spring",
      namePlural = "Queen Box Springs",
      cft = 50,
      alternateNames = listOf("Queen Bed Box Spring"),
      imageName = "box-spring",
      families = listOf(boxSprings, bedroom)
    )
    val queenMattress = ItemToAdd(
      uuid = UUID.fromString("633270C6-E7DB-4C5E-A4F8-CCD8D4E0086D"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Queen Mattress",
      namePlural = "Queen Mattresses",
      cft = 50,
      alternateNames = listOf("Queen Bed Mattress"),
      imageName = "mattress",
      families = listOf(mattresses, bedroom)
    )
    val quilt = ItemToAdd(
      uuid = UUID.fromString("569E7736-9743-477C-8509-68A5170B7354"),
      category = ItemCategory.OTHER,
      nameSingular = "Quilt",
      namePlural = "Quilts",
      cft = 5,
      alternateNames = listOf("Fabric", "Quilt (In Packaging)"),
      imageName = "linens"
    )
    val rake = ItemToAdd(
      uuid = UUID.fromString("6DF88824-7513-48F6-9C43-2C21FDA22E87"),
      category = ItemCategory.OTHER,
      nameSingular = "Rake",
      namePlural = "Rakes",
      cft = 3,
      imageName = "rake",
      families = listOf(yard, shed, garage)
    )
    val recordPlayer = ItemToAdd(
      uuid = UUID.fromString("C6968275-6E6A-449A-A15E-11DD357BB085"),
      category = ItemCategory.OTHER,
      nameSingular = "Record Player",
      namePlural = "Record Players",
      cft = 3,
      imageName = "record-player",
      families = listOf(music)
    )
    val refrigerator = ItemToAdd(
      uuid = UUID.fromString("B8123279-E93D-4206-8C08-AEAFE47E23E5"),
      category = ItemCategory.OTHER,
      nameSingular = "Refrigerator",
      namePlural = "Refrigerators",
      cft = 72,
      alternateNames = listOf("Fridge"),
      imageName = "refrigerator",
      families = listOf(kitchen)
    )
    val rocker = ItemToAdd(
      uuid = UUID.fromString("1C5B802F-CADE-4857-9F49-AA907A33FA47"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Rocking Chair",
      namePlural = "Rocking Chairs",
      cft = 13,
      alternateNames = listOf("Rocker"),
      imageName = "rocker",
      families = listOf(chairs)
    )
    val rockingHorse = ItemToAdd(
      uuid = UUID.fromString("7E80CEBA-5531-4F12-8708-2F8A5258879C"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Rocking Horse",
      namePlural = "Rocking Horses",
      cft = 10,
      imageName = "rocking-horse",
      families = listOf(kidsRoom)
    )
    val rollingShelf = ItemToAdd(
      uuid = UUID.fromString("7B96E072-42AA-46A5-9A5D-06ABFE31C59A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Rolling Shelf",
      namePlural = "Rolling Shelves",
      cft = 12,
      imageName = "rolling-shelf",
      alternateNames = listOf("Portable Shelf"),
      families = listOf(shelves, workshop)
    )
    val rollingTvStand = ItemToAdd(
      uuid = UUID.fromString("573BFA26-4E46-4BA4-BD04-0C9ACBA0DD3C"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Rolling TV Stand",
      namePlural = "Rolling TV Stand",
      cft = 12,
      imageName = "rolling-tv-stand",
      alternateNames = listOf("Portable TV Stand")
    )
    val roofRack = ItemToAdd(
      uuid = UUID.fromString("F9799967-1A72-456F-9C17-7159081EA7DE"),
      category = ItemCategory.OTHER,
      nameSingular = "Roof Rack",
      namePlural = "Roof Racks",
      cft = 10,
      imageName = "roof-rack",
      families = listOf(garage, shed, attic)
    )
    val roundTable = ItemToAdd(
      uuid = UUID.fromString("3C2D00EE-EDB6-48C8-97B1-7754F2D01356"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Round Table",
      namePlural = "Round Tables",
      cft = 24,
      imageName = "round-table",
      families = listOf(tables, kitchen)
    )
    val rugLarge = ItemToAdd(
      uuid = UUID.fromString("E5202BBE-C761-4E0E-81EB-8CACFBD92309"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Rug",
      namePlural = "Large Rugs",
      cft = 12,
      alternateNames = listOf("Large Carpet"),
      imageName = "rug",
      isPotentiallyOversized = true,
      families = listOf(livingRoom, bedroom, hallway)
    )
    val rugSmall = ItemToAdd(
      uuid = UUID.fromString("594A7A0B-ADF5-43C1-B30C-B0BD0BBF8B5A"),
      category = ItemCategory.OTHER,
      nameSingular = "Small Rug",
      namePlural = "Small Rugs",
      cft = 6,
      alternateNames = listOf("Small Carpet"),
      imageName = "rug",
      families = listOf(hallway, bathroom)
    )
    val rugPad = ItemToAdd(
      uuid = UUID.fromString("CB00218D-5520-401F-93FF-7EE8902A2682"),
      category = ItemCategory.OTHER,
      nameSingular = "Rug Pad",
      namePlural = "Rug Pads",
      cft = 8,
      alternateNames = listOf("Carpet Pad"),
      imageName = "rug-pad"
    )
    val saddle = ItemToAdd(
      uuid = UUID.fromString("BFEDBA06-2B07-467E-B66E-76239A985805"),
      category = ItemCategory.OTHER,
      nameSingular = "Saddle",
      namePlural = "Saddles",
      cft = 8,
      imageName = "saddle",
      families = listOf(shed, garage, attic, yard, sports)
    )
    val segway = ItemToAdd(
      uuid = UUID.fromString("0B0E8FE8-8378-44F9-9D49-E27F87B60DB4"),
      category = ItemCategory.OTHER,
      nameSingular = "Segway",
      namePlural = "Segways",
      cft = 16,
      imageName = "segway"
    )
    val smallSafe = ItemToAdd(
      uuid = UUID.fromString("05D57AFE-40E3-4C77-8F3D-D742B5C9F847"),
      category = ItemCategory.OTHER,
      nameSingular = "Small Safe",
      namePlural = "Small Safes",
      cft = 6,
      imageName = "safe",
      families = listOf(bedroom)
    )
    val largeSafe = ItemToAdd(
      uuid = UUID.fromString("70E8C4D0-97B2-40EA-BCC8-80436EFB52A2"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Safe",
      namePlural = "Large Safes",
      cft = 32,
      imageName = "safe"
    )
    val largeStuffedAnimal = ItemToAdd(
      uuid = UUID.fromString("e72ede26-7db8-415b-a82f-edc1aba85e5d"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Stuffed Animal",
      namePlural = "Large Stuffed Animals",
      cft = 16,
      alternateNames = listOf("Large Plushie", "Large Plushy"),
      imageName = "large-stuffed-animal",
      families = listOf(bedroom, kidsRoom)
    )
    val scooter = ItemToAdd(
      uuid = UUID.fromString("7DE3BFEA-66B8-453C-8384-11B716603EDD"),
      category = ItemCategory.OTHER,
      nameSingular = "Scooter",
      namePlural = "Scooters",
      cft = 8,
      imageName = "scooter",
      families = listOf(exerciseEquipment, garage, bedroom)
    )
    val scoopStretcher = ItemToAdd(
      uuid = UUID.fromString("D22CEED7-E14A-4703-89A1-05D5C802FD01"),
      category = ItemCategory.OTHER,
      nameSingular = "Scoop Stretcher",
      namePlural = "Scoop Stretchers",
      cft = 16,
      imageName = "scoop-stretcher"
    )
    val sectionalCouch = ItemToAdd(
      uuid = UUID.fromString("86F4EDE1-CED1-4D13-AD44-803EDA3D5D70"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Sectional",
      namePlural = "Sectionals",
      cft = 96,
      alternateNames = listOf("Sectional Sofa", "Sectional Couch"),
      imageName = "sectional-couch",
      families = listOf(sofas, livingRoom, entertainmentRoom),
      isPotentiallyOversized = true
    )
    val servingCart = ItemToAdd(
      uuid = UUID.fromString("2F6CA4BD-D7FB-40A5-BD78-A40746BAFC6B"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Serving Cart",
      namePlural = "Serving Carts",
      cft = 24,
      imageName = "serving-cart",
      families = listOf(diningRoom)
    )
    val sewingMachine = ItemToAdd(
      uuid = UUID.fromString("483C1A8F-4FB6-4973-A423-1395C27F6C66"),
      category = ItemCategory.OTHER,
      nameSingular = "Sewing Machine",
      namePlural = "Sewing Machines",
      cft = 2,
      imageName = "sewing-machine",
      families = listOf(workshop)
    )
    val sheetMusicStand = ItemToAdd(
      uuid = UUID.fromString("6AC7D96D-9736-4D6C-9425-7F2975BE74B6"),
      category = ItemCategory.OTHER,
      nameSingular = "Sheet Music Stand",
      namePlural = "Sheet Music Stands",
      cft = 3,
      imageName = "sheet-music-stand",
      families = listOf(music)
    )
    val shelfBoards = ItemToAdd(
      uuid = UUID.fromString("CB7F3ADB-249A-4339-A46F-83B0A556948F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Shelf Boards",
      namePlural = "Sets of Shelf Boards",
      cft = 4,
      imageName = "wood-sheet",
      families = listOf(shelves, bedroom, closet, attic)
    )
    val shelfSmall = ItemToAdd(
      uuid = UUID.fromString("AAC7EB40-469E-43FD-AB18-2646A5F57699"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Small Shelf",
      namePlural = "Small Shelves",
      cft = 12,
      imageName = "shelves",
      families = listOf(shelves, bedroom)
    )
    val shelfMedium = ItemToAdd(
      uuid = UUID.fromString("9ACFA35F-E38D-4B2F-BA95-C0DDC960080C"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Medium Shelf",
      namePlural = "Medium Shelves",
      cft = 24,
      imageName = "shelves",
      families = listOf(shelves, bedroom)
    )
    val shelfLarge = ItemToAdd(
      uuid = UUID.fromString("C12D7CBC-E093-409D-9A73-F42D363E808F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Large Shelf",
      namePlural = "Large Shelves",
      cft = 48,
      imageName = "shelves",
      families = listOf(shelves, livingRoom)
    )
    val shelfWithDrawers = ItemToAdd(
      uuid = UUID.fromString("FAE677EC-D96A-4900-871E-8A8633AB49D2"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Shelf With Drawers",
      namePlural = "Shelves With Drawers",
      cft = 16,
      imageName = "shelf-with-drawers",
      families = listOf(drawers, shelves, bedroom)
    )
    val shoeBox = ItemToAdd(
      uuid = UUID.fromString("9D2583E0-3E2F-4BE2-A922-13888F615532"),
      category = ItemCategory.OTHER,
      nameSingular = "Shoe Box",
      namePlural = "Shoe Boxes",
      cft = 1,
      imageName = "shoe-box",
      families = listOf(closet, bedroom, hallway)
    )
    val shoeRack = ItemToAdd(
      uuid = UUID.fromString("414D51F1-9C65-412D-9DE8-16AE28C090C2"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Shoe Rack",
      namePlural = "Shoe Racks",
      cft = 8,
      imageName = "shoe-rack",
      families = listOf(hallway)
    )
    val shovel = ItemToAdd(
      uuid = UUID.fromString("30582178-57B2-4578-B128-834AECA65635"),
      category = ItemCategory.OTHER,
      nameSingular = "Shovel",
      namePlural = "Shovels",
      cft = 4,
      imageName = "shovel",
      families = listOf(yard, shed, garage)
    )
    val singleBedFrame = ItemToAdd(
      uuid = UUID.fromString("FC5220E2-0B97-4796-B32F-527A79F54A6E"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Single Bed Frame",
      namePlural = "Single Bed Frames",
      cft = 24,
      imageName = "bed-frame",
      alternateNames = listOf("Twin Bed Frame"),
      families = listOf(bedFrames, bedroom, kidsRoom)
    )
    val singleBoxSpring = ItemToAdd(
      uuid = UUID.fromString("6921F50E-4397-4FA3-AA35-5B097D3AB075"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Single Box Spring",
      namePlural = "Single Box Springs",
      cft = 32,
      alternateNames = listOf("Twin Box Spring"),
      imageName = "box-spring",
      families = listOf(boxSprings, bedroom, kidsRoom)
    )
    val singleDresser = ItemToAdd(
      uuid = UUID.fromString("F98DEE41-FD54-44C3-8AA5-0A2409905C5F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Single Dresser",
      namePlural = "Single Dressers",
      cft = 20,
      alternateNames = listOf("Bureau", "Chest of drawers"),
      imageName = "dresser",
      families = listOf(dressers, drawers, bedroom)
    )
    val singleMattress = ItemToAdd(
      uuid = UUID.fromString("29A82EA2-D173-419B-AB75-8AEFF2357C87"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Single Mattress",
      namePlural = "Single Mattresses",
      cft = 20,
      alternateNames = listOf("Single Bed Mattress", "Twin Mattress"),
      imageName = "mattress",
      families = listOf(mattresses, bedroom, kidsRoom)
    )
    val skateboard = ItemToAdd(
      uuid = UUID.fromString("BA8146D6-1DCF-4586-B4FA-FBFBB1CCFDD0"),
      category = ItemCategory.OTHER,
      nameSingular = "Skateboard",
      namePlural = "Skateboards",
      cft = 2,
      imageName = "skateboard",
      families = listOf(sports, garage, shed)
    )
    val skis = ItemToAdd(
      uuid = UUID.fromString("B7CF6DEC-6116-416D-A1A7-52B92FA5990C"),
      category = ItemCategory.OTHER,
      nameSingular = "Skis",
      namePlural = "Skis",
      cft = 4,
      imageName = "skis",
      families = listOf(sports, garage, shed)
    )
    val skiShoes = ItemToAdd(
      uuid = UUID.fromString("7AE9F315-104C-4CED-AFAF-58EC47C82159"),
      category = ItemCategory.OTHER,
      nameSingular = "Ski Shoes",
      namePlural = "Ski Shoes",
      cft = 2,
      imageName = "ski-shoes",
      families = listOf(sports, garage, shed)
    )
    val sleepingBag = ItemToAdd(
      uuid = UUID.fromString("C1E0D5E5-2F22-4075-AF12-F27996F1FD4C"),
      category = ItemCategory.OTHER,
      nameSingular = "Sleeping Bag",
      namePlural = "Sleeping Bags",
      cft = 3,
      imageName = "sleeping-bag",
      families = listOf(camping)
    )
    val smallRange = ItemToAdd(
      uuid = UUID.fromString("B55FE746-12E7-44EA-A677-B508DAF4C5C9"),
      category = ItemCategory.OTHER,
      nameSingular = "Small Range (20\" Wide)",
      namePlural = "Small Ranges (20\" Wide)",
      cft = 48,
      alternateNames = listOf("Small Stove", "Small Oven"),
      imageName = "small-range",
      families = listOf(kitchen)
    )
    val smallAquarium = ItemToAdd(
      uuid = UUID.fromString("483825EB-7B87-4F57-B622-5C469ED10D21"),
      category = ItemCategory.OTHER,
      nameSingular = "Small Aquarium",
      namePlural = "Small Aquariums",
      cft = 8,
      alternateNames = listOf("Small Fish Tank"),
      imageName = "small-aquarium"
    )
    val smallBox = ItemToAdd(
      uuid = UUID.fromString("82FF22B3-3097-492C-9D45-4D57517F680B"),
      category = ItemCategory.BOX,
      nameSingular = "Small Box",
      namePlural = "Small Boxes",
      cft = 2,
      imageName = "box",
      families = listOf(boxes)
    )
    val smallCabinet = ItemToAdd(
      uuid = UUID.fromString("4A7E987E-7C8B-421E-8E2D-ACAD7AEE0992"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Small Cabinet",
      namePlural = "Small Cabinets",
      cft = 16,
      imageName = "cabinet",
      families = listOf(cabinets, diningRoom)
    )
    val smallDesk = ItemToAdd(
      uuid = UUID.fromString("85CF4279-4E60-4A30-9C2B-0395341BA542"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Small Desk",
      namePlural = "Small Desks",
      cft = 24,
      alternateNames = listOf("Computer Table"),
      imageName = "desk",
      families = listOf(tables, office, bedroom)
    )
    val smallEntertainmentCenter = ItemToAdd(
      uuid = UUID.fromString("B5A1E8C0-DEB8-436F-A0D2-B16B9FB0B962"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Small Entertainment Center",
      namePlural = "Small Entertainment Centers",
      cft = 16,
      alternateNames = listOf("Media Center", "TV Stand"),
      imageName = "television-stand",
      families = listOf(tvAndEntertainment, drawers, entertainmentRoom)
    )
    val smallFramedPicture = ItemToAdd(
      uuid = UUID.fromString("B3BB094B-3082-4F69-8D0A-77E7A7D1FD68"),
      category = ItemCategory.OTHER,
      nameSingular = "Small Framed Picture",
      namePlural = "Small Framed Pictures",
      cft = 2,
      alternateNames = listOf("Painting", "Small Framed Art"),
      imageName = "large-framed-picture",
      families = listOf(art)
    )
    val smallMirror = ItemToAdd(
      uuid = UUID.fromString("B7D7106A-3A46-4D49-86A4-26C60A866CC6"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Small Mirror",
      namePlural = "Small Mirrors",
      cft = 4,
      imageName = "small-mirror",
      families = listOf(bathroom, bedroom)
    )
    val smallTelevision = ItemToAdd(
      uuid = UUID.fromString("C90E7585-0F86-4F8E-8374-39C7D100D150"),
      category = ItemCategory.OTHER,
      nameSingular = "Small Television",
      namePlural = "Small Televisions",
      cft = 12,
      alternateNames = listOf("Small TV"),
      imageName = "television",
      families = listOf(tvAndEntertainment, bedroom, livingRoom, entertainmentRoom, kitchen)
    )
    val snowblower = ItemToAdd(
      uuid = UUID.fromString("A5B3DDF2-E820-4E4F-8F17-4D92DDF0C313"),
      category = ItemCategory.OTHER,
      nameSingular = "Snowblower",
      namePlural = "Snowblowers",
      cft = 32,
      imageName = "snowblower",
      families = listOf(garage, shed)
    )
    val snowboard = ItemToAdd(
      uuid = UUID.fromString("E824BF96-B15D-452E-A844-7B37FC34E118"),
      category = ItemCategory.OTHER,
      nameSingular = "Snowboard",
      namePlural = "Snowboards",
      cft = 4,
      imageName = "snowboard",
      families = listOf(sports, garage, shed)
    )
    val sofa1Cushion = ItemToAdd(
      uuid = UUID.fromString("4A0B33F8-8CB1-4FD6-BAC6-14FA4A8B9E0B"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Sofa (1 Cushion)",
      namePlural = "Sofas (1 Cushion)",
      cft = 40,
      alternateNames = listOf(
        "Recliner",
        "Lazy Boy",
        "1 Cushion Couch",
        "1 Seat Couch",
        "1 Seat Sofa",
        "One Cushion Couch",
        "One Seat Couch",
        "One Cushion Sofa",
        "One Seat Sofa"
      ),
      imageName = "sofa-1",
      families = listOf(sofas, chairs, livingRoom, bedroom, entertainmentRoom)
    )
    val sofa2Cushion = ItemToAdd(
      uuid = UUID.fromString("1DDC8F71-5252-43F1-AD0C-698110B2E1E1"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Sofa (2 Cushion)",
      namePlural = "Sofas (2 Cushion)",
      cft = 52,
      alternateNames = listOf(
        "Love Seat",
        "2 Cushion Couch",
        "2 Seat Couch",
        "2 Seat Sofa",
        "Two Cushion Couch",
        "Two Seat Couch",
        "Two Cushion Sofa",
        "Two Seat Sofa"
      ),
      imageName = "sofa-2",
      families = listOf(sofas, livingRoom, entertainmentRoom),
      isPotentiallyOversized = true
    )
    val sofa3Cushion = ItemToAdd(
      uuid = UUID.fromString("800E26DB-5ADB-426E-9B5D-21CF467AB2D0"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Sofa (3 Cushion)",
      namePlural = "Sofas (3 Cushion)",
      cft = 72,
      alternateNames = listOf(
        "3 Cushion Couch",
        "3 Seat Couch",
        "3 Seat Sofa",
        "Three Cushion Couch",
        "Three Seat Couch",
        "Three Cushion Sofa",
        "Three Seat Sofa"
      ),
      imageName = "sofa-3",
      families = listOf(sofas, livingRoom, entertainmentRoom),
      isPotentiallyOversized = true
    )
    val sofa4Cushion = ItemToAdd(
      uuid = UUID.fromString("BF8EEB68-C941-4773-8B87-97B75BB13C35"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Sofa (4 Cushion)",
      namePlural = "Sofas (4 Cushion)",
      cft = 96,
      alternateNames = listOf(
        "4 Cushion Couch",
        "4 Seat Couch",
        "4 Seat Sofa",
        "Four Cushion Couch",
        "Four Seat Couch",
        "Four Cushion Sofa",
        "Four Seat Sofa"
      ),
      imageName = "sofa-4",
      families = listOf(sofas, livingRoom, entertainmentRoom),
      isPotentiallyOversized = true
    )
    val sofaBed = ItemToAdd(
      uuid = UUID.fromString("83BC3012-628A-4844-AED1-DB287B0F997A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Sofa Bed",
      namePlural = "Sofa Beds",
      cft = 64,
      imageName = "sofa-bed",
      families = listOf(sofas, bedroom),
      isPotentiallyOversized = true
    )
    val soundbar = ItemToAdd(
      uuid = UUID.fromString("6F2ADA54-8268-4FF8-B6A1-BD1684730A7E"),
      category = ItemCategory.OTHER,
      nameSingular = "Soundbar",
      namePlural = "Soundbars",
      cft = 6,
      alternateNames = listOf("Sound Bar"),
      imageName = "sound-bar",
      families = listOf(tvAndEntertainment, music)
    )
    val spaceHeater = ItemToAdd(
      uuid = UUID.fromString("544744CA-A817-4DD7-92BB-516B667FA781"),
      category = ItemCategory.OTHER,
      nameSingular = "Space Heater",
      namePlural = "Space Heaters",
      cft = 8,
      alternateNames = listOf("Portable Heater"),
      imageName = "space-heater"
    )
    val speaker = ItemToAdd(
      uuid = UUID.fromString("8350F32B-E455-4441-8092-405D73930F6A"),
      category = ItemCategory.OTHER,
      nameSingular = "Speaker",
      namePlural = "Speakers",
      cft = 8,
      alternateNames = listOf("Subwoofer", "Sound Bar"),
      imageName = "speakers",
      families = listOf(tvAndEntertainment, music)
    )
    val speedPack = ItemToAdd(
      uuid = UUID.fromString("6911D630-7ABB-4C56-BD12-E0BE7DC596CE"),
      category = ItemCategory.BOX,
      nameSingular = "Speed Pack",
      namePlural = "Speed Packs",
      cft = 24,
      imageName = "speed-pack",
      families = listOf(boxes)
    )
    val sportsEquipment = ItemToAdd(
      uuid = UUID.fromString("F86C9709-3A21-4D78-B798-32CBDA975FDE"),
      category = ItemCategory.OTHER,
      nameSingular = "Sports Equipment",
      namePlural = "Sports Equipment",
      cft = 6,
      imageName = "sports-equipment",
      families = listOf(sports)
    )
    val squattyPotty = ItemToAdd(
      uuid = UUID.fromString("E9B2C2CD-4055-42CC-931D-EC25A1C9A4C1"),
      category = ItemCategory.OTHER,
      nameSingular = "Squatty Potty",
      namePlural = "Squatty Potties",
      cft = 4,
      imageName = "squatty-potty",
      families = listOf(bathroom)
    )
    val stairmaster = ItemToAdd(
      uuid = UUID.fromString("237D9106-E80E-437C-B33D-6907D5932ED7"),
      category = ItemCategory.OTHER,
      nameSingular = "Stairmaster",
      namePlural = "Stairmasters",
      cft = 26,
      imageName = "stairmaster",
      families = listOf(exerciseEquipment, gym)
    )
    val standingDesk = ItemToAdd(
      uuid = UUID.fromString("EA089590-067A-42E2-B971-B7B547C2B93A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Standing Desk",
      namePlural = "Standing Desks",
      cft = 32,
      imageName = "standing-desk",
      families = listOf(tables, office)
    )
    val standingDeskConverter = ItemToAdd(
      uuid = UUID.fromString("8635D000-0DB1-427C-BBE0-DA30AF5D416A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Standing Desk Converter",
      namePlural = "Standing Desk Converters",
      cft = 12,
      imageName = "standing-desk-converter",
      families = listOf(office)
    )
    val statue = ItemToAdd(
      uuid = UUID.fromString("0378E8F8-D995-4702-82D6-FD45F9CDBA62"),
      category = ItemCategory.OTHER,
      nameSingular = "Sculpture",
      namePlural = "Sculptures",
      cft = 16,
      imageName = "statue",
      alternateNames = listOf("Statue"),
      families = listOf(art, hallway, livingRoom)
    )
    val stepLadder = ItemToAdd(
      uuid = UUID.fromString("F91FFA90-4CCF-4AA1-B490-18C7A63267CC"),
      category = ItemCategory.OTHER,
      nameSingular = "Step Ladder",
      namePlural = "Step Ladders",
      cft = 9,
      imageName = "step-ladder",
      families = listOf(attic, closet, garage, shed)
    )
    val stepStool = ItemToAdd(
      uuid = UUID.fromString("5EE8C92B-0D28-4A56-AEEE-F7BD3105C8C2"),
      category = ItemCategory.OTHER,
      nameSingular = "Step Stool",
      namePlural = "Step Stools",
      cft = 4,
      imageName = "step-stool",
      families = listOf(attic, closet)
    )
    val stereoAmplifier = ItemToAdd(
      uuid = UUID.fromString("EF9E3E20-DFC6-4BC8-A91D-BFD8BBEECF34"),
      category = ItemCategory.OTHER,
      nameSingular = "Stereo Amplifier",
      namePlural = "Stereo Amplifiers",
      cft = 6,
      imageName = "stereo-amplifier",
      families = listOf(tvAndEntertainment, music)
    )
    val stereoSystem = ItemToAdd(
      uuid = UUID.fromString("33E2810A-D85D-40AB-AF93-EC6A43F5F263"),
      category = ItemCategory.OTHER,
      nameSingular = "Stereo System",
      namePlural = "Stereo Systems",
      cft = 6,
      imageName = "stereo-system",
      families = listOf(tvAndEntertainment, music)
    )
    val stool = ItemToAdd(
      uuid = UUID.fromString("7716CE69-58EA-4826-94A9-E1FBB253389F"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Stool",
      namePlural = "Stools",
      cft = 4,
      alternateNames = listOf("Kitchen Stool", "Bar Stool"),
      imageName = "kitchen-stool",
      families = listOf(chairs, kitchen)
    )
    val stretcher = ItemToAdd(
      uuid = UUID.fromString("7D8A9BAB-0D4A-4074-842B-87022E045868"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Stretcher",
      namePlural = "Stretcher",
      cft = 24,
      imageName = "stretcher"
    )
    val stroller = ItemToAdd(
      uuid = UUID.fromString("85DD6F7D-653F-414E-95A8-6B064A9481C1"),
      category = ItemCategory.OTHER,
      nameSingular = "Stroller",
      namePlural = "Strollers",
      cft = 6,
      imageName = "stroller",
      families = listOf(kidsRoom, hallway, garage)
    )
    val suitcase = ItemToAdd(
      uuid = UUID.fromString("7266301D-0419-4716-BE0A-2DE2D9A5E2B8"),
      category = ItemCategory.OTHER,
      nameSingular = "Suitcase",
      namePlural = "Suitcases",
      cft = 5,
      alternateNames = listOf("Luggage", "Carry-On"),
      imageName = "suitcase",
      families = listOf(bedroom, closet)
    )
    val surfboard = ItemToAdd(
      uuid = UUID.fromString("1867EA46-AFA0-4225-8D90-24A517B4EA0C"),
      category = ItemCategory.OTHER,
      nameSingular = "Surfboard",
      namePlural = "Surfboards",
      cft = 12,
      imageName = "surfboard",
      isPotentiallyOversized = true,
      families = listOf(sports, garage, shed)
    )
    val swings = ItemToAdd(
      uuid = UUID.fromString("145E6B31-D287-49FC-81C9-6196BC801707"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Swings",
      namePlural = "Swings",
      cft = 96,
      imageName = "swings",
      families = listOf(yard)
    )
    val sword = ItemToAdd(
      uuid = UUID.fromString("BB839934-189B-41C8-A9A5-96DA51B67755"),
      category = ItemCategory.OTHER,
      nameSingular = "Sword",
      namePlural = "Swords",
      cft = 4,
      imageName = "sword-katana",
      alternateNames = listOf("Katana"),
      families = listOf(art)
    )
    val tableBase = ItemToAdd(
      uuid = UUID.fromString("5AC69FA6-BAD1-4EDA-9615-618C23DA484B"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Table Base",
      namePlural = "Table Base",
      cft = 16,
      imageName = "table-base",
      families = listOf(tables)
    )
    val tableFan = ItemToAdd(
      uuid = UUID.fromString("FE53D13C-ADFD-4703-9A49-30858A656752"),
      category = ItemCategory.OTHER,
      nameSingular = "Table Fan",
      namePlural = "Table Fans",
      cft = 5,
      imageName = "table-fan",
      families = listOf(bedroom)
    )
    val tableLamp = ItemToAdd(
      uuid = UUID.fromString("9492E772-458B-4327-8052-21376278F1AE"),
      category = ItemCategory.OTHER,
      nameSingular = "Table Lamp",
      namePlural = "Table Lamps",
      cft = 3,
      imageName = "table-lamp",
      families = listOf(livingRoom, hallway, entertainmentRoom)
    )
    val tableLegs = ItemToAdd(
      uuid = UUID.fromString("7BB4BCE2-4A77-4A16-975A-5326EF36B5A9"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Table Legs",
      namePlural = "Table Legs",
      cft = 3,
      imageName = "table-legs",
      families = listOf(tables)
    )
    val tablePad = ItemToAdd(
      uuid = UUID.fromString("D9DC1618-727C-472E-9918-A41FB42E7087"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Table Pad",
      namePlural = "Table Pads",
      cft = 3,
      imageName = "table-pad",
      families = listOf(tables)
    )
    val tableSaw = ItemToAdd(
      uuid = UUID.fromString("6FD0A5A8-E5DC-4BF7-BE15-DDB6FA1BABBD"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Table Saw",
      namePlural = "Table Saws",
      cft = 16,
      imageName = "table-saw",
      families = listOf(tables, shed, workshop, garage)
    )
    val tableTop = ItemToAdd(
      uuid = UUID.fromString("CEAF65A4-82A0-45D3-881B-B6F777C34A2E"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Table Top",
      namePlural = "Table Tops",
      cft = 12,
      imageName = "table-top",
      families = listOf(tables)
    )
    val tansu = ItemToAdd(
      uuid = UUID.fromString("68A36CB2-93C8-40A3-BA1C-AE746C6BEBFA"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Tansu",
      namePlural = "Tansus",
      cft = 20,
      imageName = "tansu",
      families = listOf(drawers)
    )
    val tarp = ItemToAdd(
      uuid = UUID.fromString("ABF3267C-AAFF-4E55-8D8A-4B2AA21C5C09"),
      category = ItemCategory.OTHER,
      nameSingular = "Tarp",
      namePlural = "Tarps",
      cft = 1,
      imageName = "tarp"
    )
    val televisionStand = ItemToAdd(
      uuid = UUID.fromString("0126B3D7-7150-4C50-8BF0-A5D411C75F59"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Television Stand",
      namePlural = "Television Stands",
      cft = 16,
      imageName = "television-stand",
      families = listOf(tvAndEntertainment, entertainmentRoom)
    )
    val tvWallMount = ItemToAdd(
      uuid = UUID.fromString("4448FED2-F490-4891-A412-ED28419819ED"),
      category = ItemCategory.OTHER,
      nameSingular = "TV Wall Mount",
      namePlural = "TV Wall Mounts",
      cft = 3,
      imageName = "tv-wall-mount",
      alternateNames = listOf("TV Mount"),
      families = listOf(tvAndEntertainment, entertainmentRoom)
    )
    val telescope = ItemToAdd(
      uuid = UUID.fromString("10CEB533-EB88-4328-89AB-68C365101A3C"),
      category = ItemCategory.OTHER,
      nameSingular = "Telescope",
      namePlural = "Telescope",
      cft = 8,
      imageName = "telescope",
      families = listOf(closet, kidsRoom, attic)
    )
    val tennisBallMachine = ItemToAdd(
      uuid = UUID.fromString("CFF630E1-AFC0-4D97-9B41-6CDC897970AF"),
      category = ItemCategory.OTHER,
      nameSingular = "Tennis Ball Machine",
      namePlural = "Tennis Ball Machines",
      cft = 16,
      imageName = "tennis-ball-machine",
      families = listOf(sports)
    )
    val tennisRacket = ItemToAdd(
      uuid = UUID.fromString("C6DA92B4-9604-4C43-9547-0D23304655BF"),
      category = ItemCategory.OTHER,
      nameSingular = "Tennis Racket",
      namePlural = "Tennis Rackets",
      cft = 2,
      imageName = "tennis-racket",
      families = listOf(sports, closet)
    )
    val tent = ItemToAdd(
      uuid = UUID.fromString("6D7B4DF1-B960-46CC-913C-D497EB052B06"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Tent",
      namePlural = "Tents",
      cft = 6,
      imageName = "tent",
      families = listOf(camping)
    )
    val tire = ItemToAdd(
      uuid = UUID.fromString("DA83806F-E67A-4F28-97B6-42DEEB62624B"),
      category = ItemCategory.OTHER,
      nameSingular = "Tire",
      namePlural = "Tires",
      cft = 6,
      imageName = "tire",
      families = listOf(garage)
    )
    val tireChains = ItemToAdd(
      uuid = UUID.fromString("08BE336B-9C2F-447D-8614-E627CE9B76C6"),
      category = ItemCategory.OTHER,
      nameSingular = "Tire Chain",
      namePlural = "Tire Chains",
      cft = 3,
      imageName = "tire-chains",
      families = listOf(garage)
    )
    val toaster = ItemToAdd(
      uuid = UUID.fromString("416502F7-1234-4C9B-8516-4D1142176D8F"),
      category = ItemCategory.OTHER,
      nameSingular = "Toaster Oven",
      namePlural = "Toaster Ovens",
      cft = 2,
      alternateNames = listOf("Toaster"),
      imageName = "toaster-oven",
      families = listOf(kitchen)
    )
    val toboggan = ItemToAdd(
      uuid = UUID.fromString("D386A263-EBFF-4FDE-B7EF-144A119BA80F"),
      category = ItemCategory.OTHER,
      nameSingular = "Toboggan",
      namePlural = "Toboggans",
      cft = 32,
      alternateNames = listOf("Sled"),
      imageName = "toboggan",
      families = listOf(sports, garage, attic, shed)
    )
    val toiletShelf = ItemToAdd(
      uuid = UUID.fromString("A0BFE2EB-0AD6-44E7-8703-014C852AA120"),
      category = ItemCategory.OTHER,
      nameSingular = "Toilet Shelf",
      namePlural = "Toilet Shelves",
      cft = 16,
      imageName = "toilet-shelf",
      families = listOf(shelves, bathroom)
    )
    val toolbox = ItemToAdd(
      uuid = UUID.fromString("A4A99A57-9802-4FC0-A9DA-1FB453404A66"),
      category = ItemCategory.OTHER,
      nameSingular = "Toolbox",
      namePlural = "Toolboxes",
      alternateNames = listOf("Tool Chest", "Tool Box"),
      cft = 3,
      imageName = "toolbox",
      families = listOf(garage, shed, closet, workshop)
    )
    val toolChestLarge = ItemToAdd(
      uuid = UUID.fromString("B9AB9281-56B8-4078-B1B1-F03DB06CC2AC"),
      category = ItemCategory.OTHER,
      nameSingular = "Large Tool Chest",
      namePlural = "Large Tool Chests",
      alternateNames = listOf("Large Toolbox"),
      cft = 12,
      imageName = "large-tool-chest",
      families = listOf(garage, shed, closet, workshop)
    )
    val toyChest = ItemToAdd(
      uuid = UUID.fromString("8C499A76-8471-46B4-8290-F4F51F9D89D7"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Toy Chest",
      namePlural = "Toy Chests",
      cft = 8,
      imageName = "toy-chest",
      alternateNames = listOf("Toy Box"),
      families = listOf(bins, kidsRoom, entertainmentRoom)
    )
    val trampoline = ItemToAdd(
      uuid = UUID.fromString("EEC9E244-FAB0-4378-8BD1-7C30F8C01BF4"),
      category = ItemCategory.OTHER,
      nameSingular = "Trampoline",
      namePlural = "Trampolines",
      cft = 64,
      imageName = "trampoline",
      families = listOf(exerciseEquipment, yard)
    )
    val trashBag = ItemToAdd(
      uuid = UUID.fromString("F07C51C2-21A6-451C-BC6B-919387D6E98B"),
      category = ItemCategory.OTHER,
      nameSingular = "Garbage Bag",
      namePlural = "Garbage Bags",
      cft = 6,
      imageName = "garbage-bag",
      families = listOf(kitchen)
    )
    val treadmill = ItemToAdd(
      uuid = UUID.fromString("84AE0051-6727-4B0C-8AB4-62A28ABD2A3B"),
      category = ItemCategory.OTHER,
      nameSingular = "Treadmill",
      namePlural = "Treadmills",
      cft = 30,
      alternateNames = listOf("Elliptical"),
      imageName = "treadmill",
      families = listOf(exerciseEquipment, gym)
    )
    val treeStand = ItemToAdd(
      uuid = UUID.fromString("3C53C271-52F6-4B1D-AA72-E35B1255E78C"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Tree Stand",
      namePlural = "Tree Stands",
      cft = 4,
      alternateNames = listOf("Christmas Tree Stand"),
      imageName = "christmas-tree-stand",
      families = listOf(attic, garage, shed)
    )
    val tricycle = ItemToAdd(
      uuid = UUID.fromString("1FFC756F-0ED4-483B-B4B3-C837865FC287"),
      category = ItemCategory.OTHER,
      nameSingular = "Tricycle",
      namePlural = "Tricycles",
      cft = 12,
      imageName = "tricycle",
      alternateNames = listOf("Trike"),
      families = listOf(attic, kidsRoom, yard, shed)
    )
    val triFoldingMattress = ItemToAdd(
      uuid = UUID.fromString("5CAA0E48-4E22-425B-8010-4C5C9BAD90AB"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Tri-folding Foam Mattress",
      namePlural = "Tri-folding Foam Mattresses",
      cft = 6,
      imageName = "tri-folding-mattress",
      families = listOf(mattresses)
    )
    val tripleDresser = ItemToAdd(
      uuid = UUID.fromString("C8F5E984-63E8-46D1-9CE6-0EAB2377E2D1"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Triple Dresser",
      namePlural = "Triple Dressers",
      cft = 36,
      imageName = "triple-dresser",
      families = listOf(dressers, drawers, bedroom)
    )
    val tripod = ItemToAdd(
      uuid = UUID.fromString("617040C0-83A7-4D0A-8618-46EF1BCA30AB"),
      category = ItemCategory.OTHER,
      nameSingular = "Camera Tripod",
      namePlural = "Camera Tripods",
      cft = 4,
      imageName = "tripod"
    )
    val trophy = ItemToAdd(
      uuid = UUID.fromString("EDE22F14-1981-48C4-A525-660B81215E92"),
      category = ItemCategory.OTHER,
      nameSingular = "Trophy",
      namePlural = "Trophies",
      cft = 4,
      imageName = "trophy"
    )
    val trundleBed = ItemToAdd(
      uuid = UUID.fromString("F46A7D17-E3BA-4378-BE7A-98E19E43148A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Trundle Bed",
      namePlural = "Trundle Beds",
      cft = 32,
      imageName = "trundle-bed",
      families = listOf(bedFrames, kidsRoom, bedroom)
    )
    val typeWriter = ItemToAdd(
      uuid = UUID.fromString("8C201CCE-D463-474E-B3FA-F34AE6C84C87"),
      category = ItemCategory.OTHER,
      nameSingular = "Type Writer",
      namePlural = "Type Writers",
      cft = 3,
      imageName = "type-writer",
      families = listOf(office)
    )
    val umbrella = ItemToAdd(
      uuid = UUID.fromString("990973F0-3CD2-4EF8-A86D-DC2835DF1C01"),
      category = ItemCategory.OTHER,
      nameSingular = "Umbrella",
      namePlural = "Umbrellas",
      cft = 1,
      imageName = "umbrella",
      families = listOf(closet)
    )
    val umbrellaHolderStand = ItemToAdd(
      uuid = UUID.fromString("CE8043B0-20AB-4CAD-A3CF-649C5BE7F1AA"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Umbrella Holder Stand",
      namePlural = "Umbrellas Holder Stand",
      cft = 8,
      imageName = "umbrella-holder-stand",
      families = listOf(hallway)
    )
    val unicycle = ItemToAdd(
      uuid = UUID.fromString("3BC46E8E-6AAC-4553-9813-810552A40734"),
      category = ItemCategory.OTHER,
      nameSingular = "Unicycle",
      namePlural = "Unicycles",
      cft = 8,
      imageName = "unicycle",
      families = listOf(exerciseEquipment, sports)
    )
    val uprightPiano = ItemToAdd(
      uuid = UUID.fromString("719C469D-2B49-4137-AA3D-3A2B77E4E33A"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Upright Piano",
      namePlural = "Upright Pianos",
      cft = 65,
      imageName = "upright-piano",
      isPotentiallyOversized = true,
      families = listOf(music, livingRoom)
    )
    val vacuumSealBag = ItemToAdd(
      uuid = UUID.fromString("D5A6DF44-7792-4BD0-A139-340DDA0E1A5A"),
      category = ItemCategory.OTHER,
      nameSingular = "Vacuum Sealed Bag",
      namePlural = "Vacuum Sealed Bags",
      cft = 3,
      alternateNames = listOf("Space Bag", "Vacuum Seal Bag"),
      imageName = "space-bag"
    )
    val vacuumCleaner = ItemToAdd(
      uuid = UUID.fromString("3486FA1A-FE5C-4BB7-BAF6-02249AF73D76"),
      category = ItemCategory.OTHER,
      nameSingular = "Vacuum Cleaner",
      namePlural = "Vacuum Cleaners",
      cft = 6,
      imageName = "vacuum-cleaner"
    )
    val vanityTable = ItemToAdd(
      uuid = UUID.fromString("79097B39-44B5-4BC5-BD52-92D2C7B10368"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Vanity Table",
      namePlural = "Vanity Tables",
      cft = 20,
      imageName = "vanity-table",
      families = listOf(tables, bedroom)
    )
    val vase = ItemToAdd(
      uuid = UUID.fromString("D10B9E33-9AFC-4795-A830-F4208FC192E5"),
      category = ItemCategory.OTHER,
      nameSingular = "Vase",
      namePlural = "Vases",
      cft = 4,
      imageName = "vase",
      families = listOf(art)
    )
    val vaseStand = ItemToAdd(
      uuid = UUID.fromString("EAE470AF-16CD-4F28-9AE4-A50970404C76"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Pedestal",
      namePlural = "Pedestals",
      cft = 4,
      alternateNames = listOf("Vase Stand", "Plant Stand"),
      imageName = "vase-stand"
    )
    val wagon = ItemToAdd(
      uuid = UUID.fromString("32B4DE14-04E0-4B62-904F-92C4ECF1087B"),
      category = ItemCategory.OTHER,
      nameSingular = "Wagon",
      namePlural = "Wagons",
      cft = 16,
      imageName = "wagon",
      families = listOf(yard, shed)
    )
    val walker = ItemToAdd(
      uuid = UUID.fromString("b9cf32a9-f3ca-4c65-8505-c549d9d43e84"),
      category = ItemCategory.OTHER,
      nameSingular = "Walker",
      namePlural = "Walkers",
      cft = 5,
      imageName = "walker"
    )
    val wallArt = ItemToAdd(
      uuid = UUID.fromString("1B4934E6-EE49-4017-8A0C-25A00E7F8252"),
      category = ItemCategory.OTHER,
      nameSingular = "Wall Art",
      namePlural = "Wall Art",
      cft = 5,
      imageName = "large-framed-picture",
      families = listOf(art)
    )
    val wallClock = ItemToAdd(
      uuid = UUID.fromString("59431A01-B070-4DC5-BC8A-69415D9713F2"),
      category = ItemCategory.OTHER,
      nameSingular = "Wall Clock",
      namePlural = "Wall Clocks",
      cft = 1,
      imageName = "wall-clock"
    )
    val wallMountedAnimalHead = ItemToAdd(
      uuid = UUID.fromString("3DA2619D-7828-4E15-B871-936AA9684804"),
      category = ItemCategory.OTHER,
      nameSingular = "Wall Mounted Animal Head",
      namePlural = "Wall Mounted Animal Heads",
      cft = 10,
      imageName = "wall-mounted-animal-head",
      families = listOf(art)
    )
    val wallUnit = ItemToAdd(
      uuid = UUID.fromString("BFCFE4F1-6F4E-4BC8-8CF9-B849CF8D9044"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Wall Unit",
      namePlural = "Wall Units",
      cft = 52,
      imageName = "wall-unit",
      families = listOf(tvAndEntertainment, drawers, entertainmentRoom),
      isPotentiallyOversized = true
    )
    val wardrobe = ItemToAdd(
      uuid = UUID.fromString("B3720E42-90D5-479D-9A5B-C33DE6B5886B"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Wardrobe",
      namePlural = "Wardrobes",
      cft = 24,
      imageName = "wardrobe",
      families = listOf(dressers, bedroom)
    )
    val wardrobeBox = ItemToAdd(
      uuid = UUID.fromString("5129A9DB-1F00-42B3-8E9F-0401358898C3"),
      category = ItemCategory.BOX,
      nameSingular = "Wardrobe Box",
      namePlural = "Wardrobe Boxes",
      cft = 16,
      imageName = "wardrobe-box",
      families = listOf(boxes, bedroom)
    )
    val washer = ItemToAdd(
      uuid = UUID.fromString("EF2024FF-2FE0-469E-AEC0-4B30B2551F8F"),
      category = ItemCategory.OTHER,
      nameSingular = "Washer",
      namePlural = "Washers",
      cft = 20,
      alternateNames = listOf("Washing Machine"),
      imageName = "washer",
      families = listOf(laundryRoom, hallway, garage)
    )
    val waterCooler = ItemToAdd(
      uuid = UUID.fromString("3FDCF133-6E2C-44FB-913B-067C75F1699E"),
      category = ItemCategory.OTHER,
      nameSingular = "Water Cooler",
      namePlural = "Water Coolers",
      cft = 12,
      imageName = "watercooler",
      families = listOf(kitchen)
    )
    val waterJug = ItemToAdd(
      uuid = UUID.fromString("808EF1EC-5EDA-42C2-B9C5-742B7847429F"),
      category = ItemCategory.OTHER,
      nameSingular = "Water Jug",
      namePlural = "Water Jugs",
      cft = 2,
      imageName = "water-jug"
    )
    val rowingMachine = ItemToAdd(
      uuid = UUID.fromString("56093A96-24A4-481B-8B2D-1F67906B43E5"),
      category = ItemCategory.OTHER,
      nameSingular = "Rowing Machine",
      namePlural = "Rowing Machines",
      alternateNames = listOf("Rower Machine"),
      cft = 28,
      imageName = "water-rower-machine",
      families = listOf(exerciseEquipment, gym)
    )
    val weedWhacker = ItemToAdd(
      uuid = UUID.fromString("1BA70980-1E75-40E0-BC23-7333362870B1"),
      category = ItemCategory.OTHER,
      nameSingular = "Weed Whacker",
      namePlural = "Weed Whackers",
      cft = 4,
      imageName = "weed-whacker",
      families = listOf(yard, shed)
    )
    val wheelbarrow = ItemToAdd(
      uuid = UUID.fromString("9FDC6195-08C4-4848-97E0-03F88E231A7B"),
      category = ItemCategory.OTHER,
      nameSingular = "Wheelbarrow",
      namePlural = "Wheelbarrows",
      cft = 24,
      imageName = "wheelbarrow",
      families = listOf(yard, shed)
    )
    val wheelchair = ItemToAdd(
      uuid = UUID.fromString("2C1DC132-CA65-4B2A-8AC2-5EDD23226E37"),
      category = ItemCategory.OTHER,
      nameSingular = "Wheelchair",
      namePlural = "Wheelchairs",
      cft = 8,
      imageName = "wheelchair",
      families = listOf(chairs)
    )
    val whiteboard = ItemToAdd(
      uuid = UUID.fromString("C36C02B4-39A4-4512-9124-C62BF12CC574"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Whiteboard",
      namePlural = "Whiteboards",
      cft = 8,
      imageName = "whiteboard",
      families = listOf(office, workshop)
    )
    val wickerBasket = ItemToAdd(
      uuid = UUID.fromString("339C49C5-F393-47D7-9F9B-EC36114E3079"),
      category = ItemCategory.OTHER,
      nameSingular = "Wicker Basket",
      namePlural = "Wicker Baskets",
      cft = 4,
      imageName = "wicker-basket",
      alternateNames = listOf("Picnic Basket"),
      families = listOf(bins, deck)
    )
    val wickerChair = ItemToAdd(
      uuid = UUID.fromString("5E4C9231-FCB3-4CB2-99EB-00B535AA1249"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Wicker Chair",
      namePlural = "Wicker Chairs",
      cft = 16,
      imageName = "wicker-chair",
      families = listOf(chairs, deck, yard)
    )
    val windowBlinds = ItemToAdd(
      uuid = UUID.fromString("CE74398C-BFE1-40B2-96B0-9524A234E29C"),
      category = ItemCategory.OTHER,
      nameSingular = "Window Blinds",
      namePlural = "Window Blinds",
      cft = 5,
      imageName = "window-blinds"
    )
    val windowShades = ItemToAdd(
      uuid = UUID.fromString("592CA9F8-36E7-4C60-ADFD-58108D213899"),
      category = ItemCategory.OTHER,
      nameSingular = "Window Shades",
      namePlural = "Window Shades",
      cft = 5,
      imageName = "window-shades"
    )
    val wineFridge = ItemToAdd(
      uuid = UUID.fromString("1D051D4E-0CFD-4550-97C0-71E6DBBBD794"),
      category = ItemCategory.OTHER,
      nameSingular = "Wine Fridge",
      namePlural = "Wine Fridges",
      cft = 12,
      imageName = "wine-fridge",
      families = listOf(kitchen, diningRoom)
    )
    val wineRack = ItemToAdd(
      uuid = UUID.fromString("7DD5D9E8-C6A6-4CDC-A8C8-8FD5C495993B"),
      category = ItemCategory.OTHER,
      nameSingular = "Wine Rack",
      namePlural = "Wine Racks",
      cft = 8,
      imageName = "wine-rack",
      families = listOf(kitchen, diningRoom)
    )
    val woodBarrel = ItemToAdd(
      uuid = UUID.fromString("FF7D5420-7051-43DA-B4FA-47655C55CDA9"),
      category = ItemCategory.OTHER,
      nameSingular = "Wood Barrel",
      namePlural = "Wood Barrels",
      cft = 18,
      alternateNames = listOf("Wine Barrel", "Oak Barrel"),
      imageName = "wood-barrel"
    )
    val woodBasket = ItemToAdd(
      uuid = UUID.fromString("7723E9B3-543B-4E66-9816-D7B34597EC36"),
      category = ItemCategory.OTHER,
      nameSingular = "Wood Basket",
      namePlural = "Wood Baskets",
      cft = 4,
      imageName = "wicker-basket",
      families = listOf(bins)
    )
    val woodSheet = ItemToAdd(
      uuid = UUID.fromString("C262F1B5-098E-41A5-B5FF-354125C2A8A3"),
      category = ItemCategory.OTHER,
      nameSingular = "Wood Sheet",
      namePlural = "Wood Sheets",
      cft = 4,
      alternateNames = listOf("Piece of Wood"),
      imageName = "wood-sheet",
      families = listOf(shed, garage, workshop, yard)
    )
    val woodenCrate = ItemToAdd(
      uuid = UUID.fromString("83C00FA2-6F13-49DA-BEF0-88269AD357A7"),
      category = ItemCategory.OTHER,
      nameSingular = "Wooden Crate",
      namePlural = "Wooden Crates",
      cft = 8,
      imageName = "wooden-crate",
      families = listOf(bins)
    )
    val workbench = ItemToAdd(
      uuid = UUID.fromString("B551410F-3E7E-408A-9F14-DE8A4AAF7423"),
      category = ItemCategory.FURNITURE,
      nameSingular = "Workbench",
      namePlural = "Workbenches",
      cft = 24,
      imageName = "workbench",
      families = listOf(tables, workshop, shed, garage)
    )
    val wreath = ItemToAdd(
      uuid = UUID.fromString("28E55200-9D18-48EC-A128-DEEACF59831D"),
      category = ItemCategory.OTHER,
      nameSingular = "Wreath",
      namePlural = "Wreaths",
      cft = 3,
      imageName = "wreath"
    )
    val yogaMat = ItemToAdd(
      uuid = UUID.fromString("0FF986A1-7961-4523-BC2B-39F14BAF8CDA"),
      category = ItemCategory.OTHER,
      nameSingular = "Yoga Mat",
      namePlural = "Yoga Mats",
      cft = 3,
      imageName = "yoga-mat",
      families = listOf(exerciseEquipment, gym, bedroom)
    )

    val items: List<ItemToAdd> = listOf(

      /** Residences **/
      studio,
      oneBedroom,
      twoBedroom,
      threeBedroom,
      fourBedroom,
      fiveBedroom,

      /** Rooms **/
      closetItem,
      bathroomItem,
      bedroomItem,
      diningRoomItem,
      garageItem,
      kitchenItem,
      livingRoomItem,
      officeItem,

      /** Items **/

      acWindow,
      airFilter,
      airMattress,
      arcadeMachine,
      armchair,
      armoire,
      babyBouncer,
      babyGate,
      babyGrandPiano,
      backpack,
      bagOfClothes,
      bankersBox,
      barCart,
      basketballHoop,
      bathroomShelf,
      bbq,
      beanBag,
      bedLeg,
      bedsideLamp,
      bedSideRails,
      bedsideTable,
      bedsideTableDrawers,
      bedSlats,
      bedTray,
      bench,
      benchSeat,
      bicyclePump,
      bicycleTire,
      bicycleTrailer,
      bike,
      bikeRack,
      boardGame,
      bodyBoard,
      bookcase,
      bookcaseNarrow,
      bookcaseShort,
      bosuBall,
      briefcase,
      broom,
      bucket,
      buffet,
      bundleOfSticks,
      bunkBed,
      butcherBlockTable,
      cabinet,
      campingGear,
      candelabra,
      canvasBag,
      cardTable,
      carSeat,
      carTopCarrier,
      catTree,
      cdTower,
      ceilingFan,
      chaiseLounge,
      chalkboard,
      chandelier,
      chandelierSmall,
      changingTable,
      chestLarge,
      chestMedium,
      chestSmall,
      chinaHutch2pc,
      christmasLawnOrnament,
      christmasTree,
      coatStand,
      coffeeMaker,
      coffeeTable,
      comforter,
      concertPiano,
      conferenceTable,
      consoleTable,
      cooler,
      corkBoard,
      couchCushion,
      cradle,
      craftsmanCabinet,
      crib,
      crutches,
      cubbyBin,
      cubicleWall,
      curtainsAndRods,
      deepFryer,
      dehumidifier,
      desktopComputer,
      deskWithDrawers,
      didgeridoo,
      digitalMixer,
      diningRoomChair,
      diningRoomTable,
      diningTableGlass,
      diningTableLeaf,
      dishPack,
      dishPackMini,
      dishwasher,
      dogBed,
      dollhouse,
      dollyFurniture,
      dollyHand,
      door,
      doorMat,
      doubleBedFrame,
      doubleBoxSpring,
      doubleDresser,
      doubleMattress,
      doubleOven,
      draftingTable,
      dropLeafTable,
      drum,
      drums,
      dryer,
      duffelBag,
      dumbbellRack,
      dumbbells,
      easel,
      electricFireplace,
      electricGenerator,
      endTable,
      exerciseBike,
      exerciseEquipmentLarge,
      exerciseEquipmentSmall,
      extraLargeBox,
      extraLargeFramedPicture,
      extraSmallBox,
      ezUp,
      fan,
      fiftyFiveGallonDrum,
      filingCabinet,
      fireplaceEquipment,
      fishingRod,
      floorLamp,
      flowerPot,
      foamRoller,
      foldingChair,
      foldingTable,
      foldingWall,
      foosballTable,
      footboard,
      freezer,
      futon,
      gameConsole,
      garbageCan,
      gardenGnome,
      gardenTools,
      golfBag,
      gong,
      grandfatherClock,
      grandPiano,
      guitar,
      gunSafe,
      halloweenDecorations,
      hallTable,
      hamper,
      headboard,
      helmet,
      highChair,
      hockeyStick,
      hoseAndReel,
      hulaHoop,
      humidifier,
      insectCatchingNet,
      instantPot,
      iron,
      ironingBoard,
      jewelryBox,
      jukeBox,
      kayak,
      keyboardPiano,
      kidsChair,
      kidsSandBox,
      kidsTable,
      kingBedFrame,
      kingBoxSpring,
      kingMattress,
      kitchenCart,
      kitchenTable,
      ladder,
      lampBox,
      lampShade,
      laptop,
      largeAquarium,
      largeBox,
      largeCabinet,
      largeDesk,
      largeEntertainmentCenter,
      largeFramedPicture,
      largeKidsToy,
      largeMirror,
      largeRange,
      largeSafe,
      largeStuffedAnimal,
      largeTV,
      laundryBasket,
      laundryRack,
      lawnChair,
      lawnMower,
      leafBlower,
      leaningShelf,
      leatherBasket,
      linens,
      longboard,
      mannequin,
      massageChair,
      massageTable,
      mat,
      mattressPad,
      medicineBall,
      mediumBox,
      mediumCabinet,
      mediumFramedPicture,
      mediumRange,
      metalBedFrame,
      metalPoles,
      metalRack,
      microwave,
      miniBar,
      miniFridge,
      mirrorOrArtBox,
      monitor,
      moped,
      mosesBasket,
      officeChair,
      ottoman,
      outdoorFirePit,
      outdoorHeater,
      outdoorMetalChair,
      outdoorUmbrella,
      overstuffedChair,
      paddle,
      paintBucket,
      paperShredder,
      paperTube,
      patioTable,
      pedestalFan,
      petCarrier,
      petCrate,
      petStairs,
      pianoBench,
      picnicTable,
      pinballMachine,
      pingPongTable,
      plant,
      plasticBinLarge,
      plasticBinMedium,
      plasticBinSmall,
      plasticChair,
      plasticCrate,
      plasticDrawer,
      playard,
      pokerSet,
      pokerTable,
      poolChair,
      poolTable,
      portableAc,
      portableClothesRack,
      portableGrill,
      portableStove,
      poster,
      powerTool,
      printer,
      printer3D,
      punchingBag,
      purse,
      pushGolfCart,
      queenBedFrame,
      queenBoxSpring,
      queenMattress,
      quilt,
      rake,
      recordPlayer,
      refrigerator,
      rocker,
      rockingHorse,
      rollingShelf,
      rollingTvStand,
      roofRack,
      roundTable,
      rowingMachine,
      rugLarge,
      rugPad,
      rugSmall,
      saddle,
      scoopStretcher,
      scooter,
      sectionalCouch,
      segway,
      servingCart,
      sewingMachine,
      sheetMusicStand,
      shelfBoards,
      shelfLarge,
      shelfMedium,
      shelfSmall,
      shelfWithDrawers,
      shoeBox,
      shoeRack,
      shovel,
      singleBedFrame,
      singleBoxSpring,
      singleDrawer,
      singleDresser,
      singleMattress,
      skateboard,
      skis,
      skiShoes,
      sleepingBag,
      smallAquarium,
      smallBox,
      smallCabinet,
      smallDesk,
      smallEntertainmentCenter,
      smallFramedPicture,
      smallMirror,
      smallRange,
      smallSafe,
      smallTelevision,
      snowblower,
      snowboard,
      sofa1Cushion,
      sofa2Cushion,
      sofa3Cushion,
      sofa4Cushion,
      sofaBed,
      soundbar,
      spaceHeater,
      speaker,
      speedPack,
      sportsEquipment,
      squattyPotty,
      stairmaster,
      standingDesk,
      standingDeskConverter,
      statue,
      stepLadder,
      stepStool,
      stereoAmplifier,
      stereoSystem,
      stool,
      stretcher,
      stroller,
      suitcase,
      surfboard,
      swings,
      sword,
      tableBase,
      tableFan,
      tableLamp,
      tableLegs,
      tablePad,
      tableSaw,
      tableTop,
      tansu,
      tarp,
      telescope,
      televisionStand,
      tennisBallMachine,
      tennisRacket,
      tent,
      tire,
      tireChains,
      toaster,
      toboggan,
      toiletShelf,
      toolbox,
      toolChestLarge,
      toyChest,
      trampoline,
      trashBag,
      treadmill,
      treeStand,
      tricycle,
      triFoldingMattress,
      tripleDresser,
      tripod,
      trophy,
      trundleBed,
      tvWallMount,
      typeWriter,
      umbrella,
      umbrellaHolderStand,
      unicycle,
      uprightPiano,
      vacuumCleaner,
      vacuumSealBag,
      vanityTable,
      vase,
      vaseStand,
      wagon,
      walker,
      wallArt,
      wallClock,
      wallMountedAnimalHead,
      wallUnit,
      wardrobe,
      wardrobeBox,
      washer,
      waterCooler,
      waterJug,
      weedWhacker,
      wheelbarrow,
      wheelchair,
      whiteboard,
      wickerBasket,
      wickerChair,
      windowBlinds,
      windowShades,
      wineFridge,
      wineRack,
      woodBarrel,
      woodBasket,
      woodenCrate,
      woodSheet,
      workbench,
      wreath,
      yogaMat,

      ItemType.BuiltIn.SMALL_FURNITURE.toItemToAdd(),
      ItemType.BuiltIn.MEDIUM_FURNITURE.toItemToAdd(),
      ItemType.BuiltIn.LARGE_FURNITURE.toItemToAdd(),
      ItemType.BuiltIn.EXTRA_LARGE_FURNITURE.toItemToAdd(),

      ItemType.BuiltIn.SMALL_OTHER.toItemToAdd(),
      ItemType.BuiltIn.MEDIUM_OTHER.toItemToAdd(),
      ItemType.BuiltIn.LARGE_OTHER.toItemToAdd(),
      ItemType.BuiltIn.EXTRA_LARGE_OTHER.toItemToAdd(),

      ItemType.BuiltIn.SMALL_ITEM.toItemToAdd(),
      ItemType.BuiltIn.MEDIUM_ITEM.toItemToAdd(),
      ItemType.BuiltIn.LARGE_ITEM.toItemToAdd(),
      ItemType.BuiltIn.EXTRA_LARGE_ITEM.toItemToAdd(),

      ItemType.BuiltIn.UNKNOWN_SIZED_BOX.toItemToAdd(),
      ItemType.BuiltIn.UNKNOWN_SIZED_FURNITURE.toItemToAdd(),
      ItemType.BuiltIn.UNKNOWN_SIZED_OTHER.toItemToAdd(),
      ItemType.BuiltIn.UNKNOWN_SIZED_UNKNOWN.toItemToAdd()
    )

    // ensure there are no family uuid dupes
    familiesToAdd.groupBy { it.uuid }.forEach { uuid, families ->
      check(families.size == 1) { "Error: Duplicate UUID found: $uuid with familiesToAdd ${families.joinToString { it.namePlural }}" }
    }

    val oldFamiliesMap = getItemFamilies().associateBy { it.uuid }
    familiesToAdd.forEach { familyToAdd ->
      val entityName = EntityName(
        generic = familyToAdd.nameGeneric,
        singular = familyToAdd.nameSingular,
        plural = familyToAdd.namePlural
      )

      val existing = oldFamiliesMap[familyToAdd.uuid]
      if (existing != null) {
        updateItemFamily(
          existing.id,
          listOf(
            EntityStrings(
              locale = "en",
              name = entityName,
              alternateSearchStrings = familyToAdd.alternateNames
            )
          ),
          "https://trove.imgix.net/assets/inventory/${familyToAdd.imageName}.png",
          familyToAdd.category
        )
        println("Updated family ${entityName.plural}")
      } else {
        createItemFamily(
          familyToAdd.uuid,
          listOf(
            EntityStrings(
              locale = "en",
              name = entityName,
              alternateSearchStrings = familyToAdd.alternateNames
            )
          ),
          "https://trove.imgix.net/assets/inventory/${familyToAdd.imageName}.png",
          familyToAdd.category
        )
        println("Created family ${entityName.plural}")
      }
    }

    // ensure there are no uuid dupes
    items.groupBy { it.uuid }.forEach { uuid, dupes ->
      check(dupes.size == 1) { "Error: Duplicate UUID found: $uuid with items ${dupes.joinToString { it.nameSingular }}" }
    }

    val oldItemTypesMap = getItemTypes().associateBy { it.uuid }

    items.forEach { itemToAdd ->
      val entityName = EntityName(
        generic = itemToAdd.nameGeneric ?: itemToAdd.nameSingular,
        singular = itemToAdd.nameSingular,
        plural = itemToAdd.namePlural
      )

      val existing = oldItemTypesMap[itemToAdd.uuid]
      if (existing != null) {
        if (existing.cubicFeetEstimate != itemToAdd.cft) {
          archiveItemType(existing.id)
          createItemType(
            itemToAdd.uuid,
            itemToAdd.category,
            listOf(
              EntityStrings(
                locale = "en",
                name = entityName,
                alternateSearchStrings = itemToAdd.alternateNames
              )
            ),
            itemToAdd.cft,
            "https://trove.imgix.net/assets/inventory/${itemToAdd.imageName}.png",
            families = itemToAdd.families.map { it.uuid },
            isCanonical = true,
            isPotentiallyOversized = itemToAdd.isPotentiallyOversized
          )
          println(
            "Cubic feet changed. Old ItemType was archived and new one with same UUID " +
                "was created. ${entityName.generic}"
          )
        } else {
          updateItemType(
            existing.id,
            itemToAdd.category,
            listOf(
              EntityStrings(
                locale = "en",
                name = entityName,
                alternateSearchStrings = itemToAdd.alternateNames
              )
            ),
            itemToAdd.cft,
            "https://trove.imgix.net/assets/inventory/${itemToAdd.imageName}.png",
            families = itemToAdd.families.map { it.uuid },
            isCanonical = true,
            isPotentiallyOversized = itemToAdd.isPotentiallyOversized
          )
          println("Updated item ${entityName.generic}")
        }
      } else {
        createItemType(
          itemToAdd.uuid,
          itemToAdd.category,
          listOf(
            EntityStrings(
              locale = "en",
              name = entityName,
              alternateSearchStrings = itemToAdd.alternateNames
            )
          ),
          itemToAdd.cft,
          "https://trove.imgix.net/assets/inventory/${itemToAdd.imageName}.png",
          families = itemToAdd.families.map { it.uuid },
          isCanonical = true,
          isPotentiallyOversized = itemToAdd.isPotentiallyOversized
        )
        println("Created item ${entityName.generic}")
      }
    }
  }

  private data class FamilyToAdd(
    val uuid: UUID,
    val nameGeneric: String,
    val nameSingular: String,
    val namePlural: String,
    val alternateNames: List<String> = listOf(),
    val imageName: String,
    val category: ItemFamilyCategory
  )

  private data class ItemToAdd(
    val uuid: UUID,
    val category: ItemCategory = ItemCategory.UNKNOWN,
    val nameGeneric: String? = null,
    val nameSingular: String,
    val namePlural: String,
    val cft: Int,
    val alternateNames: List<String> = listOf(),
    val imageName: String,
    val families: List<FamilyToAdd> = emptyList(),
    val isPotentiallyOversized: Boolean = false)
}

inline fun String.toUUID(): UUID = UUID.fromString(this)


fun getItemFamilies(): List<ItemFamily> {
  return listOf()
}

fun updateItemFamily(
  itemFamilyId: Long,
  strings: List<EntityStrings>? = null,
  imageUrl: String? = null,
  category: ItemFamilyCategory? = null) {

}

fun createItemFamily(uuid: UUID, entityStrings: List<EntityStrings>, imageUrl: String, category: ItemFamilyCategory) {

}

fun getItemTypes(): List<ItemType> {
  return listOf()
}


fun createItemType(
  uuid: UUID,
  category: ItemCategory,
  strings: List<EntityStrings>,
  cubicFeetEstimate: Int,
  imageUrl: String,
  families: List<UUID>,
  isCanonical: Boolean,
  isPotentiallyOversized: Boolean) {
}

fun archiveItemType(
  itemTypeId: Long) {

}

fun updateItemType(
  itemTypeId: Long,
  category: ItemCategory? = null,
  strings: List<EntityStrings>? = null,
  cubicFeetEstimate: Int? = null,
  imageUrl: String? = null,
  families: List<UUID>? = null,
  isCanonical: Boolean? = null,
  isPotentiallyOversized: Boolean? = null) {

}
