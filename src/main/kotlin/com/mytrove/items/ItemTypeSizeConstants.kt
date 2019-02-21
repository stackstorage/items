package com.mytrove.items

/**
 * All sizes are in cubic feet.
 *
 * This class is only necessary until ItemTypes are the source of truth for all storage space
 * calculations
 */
object ItemTypeSizeConstants {

  /** Items  */

  val bedsideLamp = 24
  val bedsideTable = 24
  val bike = 16
  val bookcase = 32
  val cabinet = 24
  val campingGear = 24
  val chinaHutch = 80
  val chaiseLounge = 32
  val coffeeMaker = 5
  val coffeeTable = 32
  val computer = 16
  val diningRoomChair = 16
  val diningRoomTable = 48
  val doubleDresser = 64
  val floorLamp = 8
  val garbageCan = 11
  val gardenTools = 8
  val golfBag = 16
  val hamper = 8
  val kitchenTable = 32
  val largeDesk = 56
  val largeTV = 56
  val mediumBox = 5
  val microwave = 8
  val plant = 5
  val queenBedFrame = 64
  val queenMattress = 40
  val rug = 16
  val smallEntertainmentCenter = 48
  val smallMirror = 5
  val stereoSystem = 6
  val threeCushionSofa = 72
  val toaster = 6
  val shoeRack = 16

  /** Rooms  */

  val bathroom = mediumBox * 3
  val bedroom = doubleDresser + queenBedFrame + queenMattress + smallMirror +
      hamper + bedsideLamp + bedsideTable + 8 * mediumBox
  val diningRoom = 6 * diningRoomChair + diningRoomTable + chinaHutch + rug
  val garage = 64 * mediumBox
  val kitchen = kitchenTable + 4 * diningRoomChair + toaster + microwave +
      garbageCan + coffeeMaker + 6 * mediumBox
  val livingRoom = coffeeTable + plant + largeTV + stereoSystem +
      threeCushionSofa + floorLamp + chaiseLounge + bookcase +
      smallEntertainmentCenter
  val office = computer + cabinet + largeDesk
  val closet = hamper + 2 * shoeRack + 12 * mediumBox

  /** Residences  */

  val VAULT_VOLUME_TO_AREA_DIVISOR = 8

  val studio = 50 * VAULT_VOLUME_TO_AREA_DIVISOR
  val oneBr = 75 * VAULT_VOLUME_TO_AREA_DIVISOR
  val twoBr = 100 * VAULT_VOLUME_TO_AREA_DIVISOR
  val threeBr = 150 * VAULT_VOLUME_TO_AREA_DIVISOR
  val fourBr = 225 * VAULT_VOLUME_TO_AREA_DIVISOR
  val fiveBr = 300 * VAULT_VOLUME_TO_AREA_DIVISOR
}
