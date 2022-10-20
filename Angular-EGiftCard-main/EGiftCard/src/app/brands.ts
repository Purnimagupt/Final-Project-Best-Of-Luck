export class Brands {
    brandId: number;
    brandName: String;
    brandDescription: String;
    imageUrl: String;

    constructor(brandId: number,
        brandName: String,
        brandDescription: String,
        imageUrl: String) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandDescription = brandDescription;
        this.imageUrl = imageUrl;
    }
}
