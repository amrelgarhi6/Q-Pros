package api.base_paths;

import lombok.Getter;

@Getter
public enum BasePath {
    POST_USER("/api/v3/user"),
    GET_USER("/api/v3/user/"),
    PUT_USER("/api/v3/user/"),
    DELETE_USER("/api/v3/user/");
    public final String basePath;

    BasePath(String basePath) {
        this.basePath = basePath;
    }
}