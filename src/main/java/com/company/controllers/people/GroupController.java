package com.company.controllers.people;

import com.company.services.people.GroupService;

public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
//        Assert.notNull(groupService);
        this.groupService = groupService;
    }
}
