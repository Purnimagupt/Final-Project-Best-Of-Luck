import { GiftCard } from "./gift-card";
import { User } from "./user";

export class UserGiftDetails {
    userGiftId: number;
    giftCardAmount: number;
    cardIssueDate: Date;
    recepientName: string;
    recepientMobile: number;
    recepientEmail: string;
    deliveryType: string;
    message: string;
    scheduleDelivery: Date;
    user: User;
    giftCard: GiftCard;


    constructor(userGiftId: number,
        giftCardAmount: number,
        cardIssueDate: Date,
        recepientName: string,
        recepientMobile: number,
        recepientEmail: string,
        deliveryType: string,
        message: string,
        scheduleDelivery: Date,
        user: User,
        giftCard: GiftCard,
    ) {
        this.userGiftId = userGiftId;
        this.giftCardAmount = giftCardAmount;
        this.cardIssueDate = cardIssueDate;
        this.recepientName = recepientName;
        this.recepientMobile = recepientMobile;
        this.recepientEmail = recepientEmail;
        this.deliveryType = deliveryType;
        this.message = message;
        this.scheduleDelivery = scheduleDelivery;
        this.user = user;
        this.giftCard = giftCard;
    }

    toString(): string {
        return this.userGiftId + 'userGiftId' +
            this.giftCardAmount + 'giftCardAmount' +
            this.cardIssueDate + 'cardIssueDate' +
            this.recepientName + 'recepientName' +
            this.recepientMobile + 'recepientMobile' +
            this.recepientEmail + 'recepientEmail' +
            this.deliveryType + 'deliveryType' +
            this.message + 'message' +
            this.scheduleDelivery + 'scheduleDelivery' +
            this.user + 'user' +
            this.giftCard + 'giftCard'

    }
}
