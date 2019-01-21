def call() {
  def job = Jenkins.getInstance().getItemByFullName(env.JOB_BASE_NAME, Job.class)
  def build = job.getBuildByNumber(env.BUILD_ID as int)
  def userId = build.getCause(Cause.UserIdCause).getUserId()
  echo userId

  def users = [:]
  def authStrategy = Jenkins.instance.getAuthorizationStrategy()
  if(authStrategy instanceof RoleBasedAuthorizationStrategy){
    //if def sids = authStrategy.roleMaps.globalRoles.getSidsForRole(role)
    //sids.each { sid ->
    //  users[sid] = Jenkins.instance.getUser(sid).fullName
    //}
  } else {
    throw new Exception("Error: Role Strategy Plugin not in use.")
  }
}
