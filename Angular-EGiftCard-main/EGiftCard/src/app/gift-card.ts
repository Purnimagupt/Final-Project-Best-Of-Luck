import { Brands } from "./brands";

export class GiftCard {

    giftcardId: number;
    brand: Brands;

    constructor(giftCardId: number,
        brand: Brands) {

        this.giftcardId = giftCardId;
        this.brand = brand;
    }

}
