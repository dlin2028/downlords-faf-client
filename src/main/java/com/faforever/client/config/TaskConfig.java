package com.faforever.client.config;

import com.faforever.client.map.DownloadMapTask;
import com.faforever.client.map.MapUploadTask;
import com.faforever.client.map.UninstallMapTask;
import com.faforever.client.mod.InstallModTask;
import com.faforever.client.mod.ModUploadTask;
import com.faforever.client.mod.UninstallModTask;
import com.faforever.client.patch.GitCheckGameUpdateTask;
import com.faforever.client.patch.UpdateGameFilesTask;
import com.faforever.client.replay.LoadLocalReplaysTask;
import com.faforever.client.replay.ReplayDownloadTask;
import com.faforever.client.update.CheckForUpdateTask;
import com.faforever.client.update.DownloadUpdateTask;
import com.faforever.client.uploader.imgur.ImgurUploadTask;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
@Import(BaseConfig.class)
public class TaskConfig {

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  UpdateGameFilesTask updateGameFilesTask() {
    return new UpdateGameFilesTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  InstallModTask downloadModTask() {
    return new InstallModTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  CheckForUpdateTask checkForUpdateTask() {
    return new CheckForUpdateTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  DownloadUpdateTask downloadUpdateTask() {
    return new DownloadUpdateTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  GitCheckGameUpdateTask gitCheckGameUpdateTask() {
    return new GitCheckGameUpdateTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  ImgurUploadTask imgurUploadTask() {
    return new ImgurUploadTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  ReplayDownloadTask replayDownloadTask() {
    return new ReplayDownloadTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  LoadLocalReplaysTask loadLocalReplaysTask() {
    return new LoadLocalReplaysTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  DownloadMapTask downloadMapTask() {
    return new DownloadMapTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  UninstallModTask uninstallModTask() {
    return new UninstallModTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  UninstallMapTask uninstallMapTask() {
    return new UninstallMapTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  ModUploadTask uploadModTask() {
    return new ModUploadTask();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  MapUploadTask uploadMapTask() {
    return new MapUploadTask();
  }
}
