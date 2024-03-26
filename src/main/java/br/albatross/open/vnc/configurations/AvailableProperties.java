package br.albatross.open.vnc.configurations;

public interface AvailableProperties {

    String CONNECTION_USER            = "VNC_USER";
    String CONNECTION_PASSWORD        = "VNC_PASSWORD";

    String APP_MAIN_WINDOW_TITLE      = "OpenVNC by Albatross";
    String APP_ICON_RESOURCE_PATH     = "acesso-remoto.png";
    String DEV_GITHUB_PAGE_LINK       = "https://github.com/brenoyure";

    String ON_WINDOWS_VNC_HOME_DIR = "VNC_HOME_DIR";

    boolean IS_LINUX_OS   =   System.getProperty("os.name").contains("Linux");
    boolean IS_WINDOWS_OS = !(System.getProperty("os.name").contains("Linux"));

}
