package com.dc.dcrud.searcher;

import com.dc.dcrud.domain.UserEntity;
import com.dc.dcrud.web.view.support.viewpojo.datatable.DataTableConfig;
import com.dc.dcrud.web.view.support.viewpojo.datatable.TableColumnConfig;
import com.dc.dcrud.web.view.support.viewpojo.datatable.TableOptionButtonConfig;
import com.dc.dcrud.web.view.support.viewpojo.inputview.ConditionViewTitle;
import com.dc.dcrud.web.view.support.viewpojo.inputview.SelectInput;
import com.dc.dcrud.web.view.support.viewpojo.inputview.TextInput;
import com.dc.dcrud.web.view.support.viewpojo.optionbutton.OptionButton;
import com.dc.dcrud.web.view.support.viewpojo.optionbutton.OptionButtons;
import com.dc.frame2.core.dao.condition.CompareOperator;
import com.dc.frame2.core.dao.condition.Condition;
import com.dc.frame2.core.dao.condition.JoinType;
import com.dc.frame2.core.dto.PageSearcher;

/**
 * <p>Descriptions...
 *
 * @author DC
 * @date 2018/4/14.
 */

@OptionButtons({
        @OptionButton(name = "crud.query.option.add", href = "add"),
})
@DataTableConfig(
        columns = {
                @TableColumnConfig(
                        path = "username", headName = "com.dc.dcrud.domain.UserEntity.username"
                ),
                @TableColumnConfig(
                        path = "nickName", headName = "com.dc.dcrud.domain.UserEntity.nickName"
                ),
                @TableColumnConfig(
                        path = "roles", headName = "com.dc.dcrud.domain.UserEntity.roles",
                        sortable = false
                ),
                @TableColumnConfig(
                        path = "createDateTime", headName = "com.dc.dcrud.domain.createDateTime"
                ),
                @TableColumnConfig(
                        path = "updateDateTime", headName = "com.dc.dcrud.domain.updateDateTime"
                ),
        }, buttons = {
        @TableOptionButtonConfig(name = "crud.query.table.option.update", href = "edit"),
        @TableOptionButtonConfig(name = "crud.query.table.option.delete", href = "delete",
                ajax = true,
                ajaxConfirm = true)
})
@ConditionViewTitle("crud.userEntity.query.condition.title")
public class UserSearcher extends PageSearcher<UserEntity> {
    @TextInput
    @Condition(operator = CompareOperator.DUP_LIKE)
    private String nickName;
    @Condition(operator = CompareOperator.DUP_LIKE)
    @TextInput
    private String username;
    @Condition(operator = CompareOperator.EQ, value = "roles.id", joinType = JoinType.LEFT)
    @SelectInput(placeHolder = "crud.query.condition.select.option.all", optionProvider = "HqlOptionProvider", optionProviderKey = "select name,id from RoleEntity")
    private Long roles;
    
    public String getUsername() {
        return username;
    }
    
    public UserSearcher setUsername(String username) {
        this.username = username;
        return this;
    }
    
    public String getNickName() {
        return nickName;
    }
    
    public UserSearcher setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }
    
    public Long getRoles() {
        return roles;
    }
    
    public UserSearcher setRoles(Long roles) {
        this.roles = roles;
        return this;
    }
}
