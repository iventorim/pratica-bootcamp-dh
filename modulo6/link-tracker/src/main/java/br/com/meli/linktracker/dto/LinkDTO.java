package br.com.meli.linktracker.dto;

import java.util.UUID;

public class LinkDTO {

    private UUID linkID;

    public LinkDTO(UUID linkID) {
        this.linkID = linkID;
    }

    public static LinkDTO convert(UUID id) {
        return new LinkDTO(id);
    }

    public UUID getLinkID() {
        return linkID;
    }

    public void setLinkID(UUID linkID) {
        this.linkID = linkID;
    }
}
