package api.base_uris;

import lombok.Getter;

@Getter
public enum BaseURI {
    PETSTORE_BASE("https://petstore3.swagger.io");

    private final String baseURI;

    BaseURI(String baseURI) {
        this.baseURI = baseURI;
    }
}