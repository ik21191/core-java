package structure.proxy;

interface CommandExecutor {
  public void runCommand(String cmd);
}


class CommandExecutorImpl implements CommandExecutor {

  @Override
  public void runCommand(String cmd) {
    System.out.println("'" + cmd + "' command executed.");
  }
}


class CommandExecutorProxy implements CommandExecutor {

  private boolean isAdmin;
  private CommandExecutor executor;

  public CommandExecutorProxy(String user) {
    if ("vinay".equalsIgnoreCase(user)) {
      isAdmin = true;
    }
    executor = new CommandExecutorImpl();
  }

  @Override
  public void runCommand(String cmd) {
    if (isAdmin) {
      executor.runCommand(cmd);
    } else {
      if (cmd.trim().startsWith("rm")) {
        throw new RuntimeException("rm command is not allowed for non-admin users.");
      } else {
        executor.runCommand(cmd);
      }
    }
  }
}


public class ProxyDesignPatternDemo {
  public static void main(String[] args) {
    CommandExecutor executor = new CommandExecutorProxy("Imran");
    try {
      executor.runCommand("ls -ltr");
      executor.runCommand(" rm -rf abc.pdf");
    } catch (Exception e) {
      System.out.println("Exception Message::" + e.getMessage());
    }
  }
}
