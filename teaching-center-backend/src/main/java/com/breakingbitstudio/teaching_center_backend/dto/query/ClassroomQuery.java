package com.breakingbitstudio.teaching_center_backend.dto.query;

import com.breakingbitstudio.teaching_center_backend.dto.common.QueryOptions;

public class ClassroomQuery extends QueryOptions {
    private boolean archived;

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
