package org.elasticsearch.plugin.readonlyrest;

import org.elasticsearch.action.ActionModule;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestModule;

public class ReadonlyRestPlugin extends AbstractPlugin {

  @Override
  public String name() {
    return "readonlyrest";
  }

  @Override
  public String description() {
    return "Reject attempts to change data, so we can expose this REST API to clients";
  }

  public void onModule(RestModule module) {
    module.addRestAction(ReadonlyRestAction.class);
  }

  public void onModule(final ActionModule module) {
    module.registerFilter(IndexLevelActionFilter.class);
  }

}
