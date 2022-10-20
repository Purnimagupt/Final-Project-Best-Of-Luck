import { UserGiftDetails } from "./user-gift-details";

export class Payment {

    paymentId: number;
    fullName: string;
    paymentDate: Date;
    nameOnCard: string;
    paymentAmount: number;
    cardNumber: number;
    cardExpiry: Date;
    cvv: number;
    userGiftDetails: UserGiftDetails


    constructor(paymentId: number,
        fullName: string,
        paymentDate: Date,
        nameOnCard: string,
        paymentAmount: number,
        cardNumber: number,
        cardExpiry: Date,
        cvv: number,
        userGiftDetails: UserGiftDetails) {
        this.paymentId = paymentId;
        this.fullName = fullName;
        this.paymentDate = paymentDate;
        this.nameOnCard = nameOnCard;
        this.paymentAmount = paymentAmount;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cvv = cvv;
        this.userGiftDetails = userGiftDetails
    }

    toString(): string {
        return this.paymentId + 'paymentId' +
            this.fullName + 'fullName' +
            this.paymentDate + 'paymentDate' +
            this.nameOnCard + 'nameOnCard' +
            this.paymentAmount + 'paymentAmount' +
            this.cardNumber + 'cardNumber' +
            this.cardExpiry + 'cardExpiry' +
            this.cvv + 'cvv' +
            this.userGiftDetails + 'userGiftDetails'


    }
}
