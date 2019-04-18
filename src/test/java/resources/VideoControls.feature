@Do

Feature: Video Play/Pause Controls

  Background: 'When the video is playing, its' progress is measurable. It is expected that play and pause buttons
  are inversely related. Whenever the video is playing, the pause button should be displayed. And conversely,
  when the video is paused, then the play button should appear.

    Scenario Outline: Playing/Pausing a video
    Given The page is loaded
    When a "<button>" button is clicked
    And  the user waits "<duration>" seconds
    Then video time duration progress is "<duration>" seconds
    And "<enabledButton>" button will be enabled



    Examples:
      | button     | enabledButton  | duration |
      | play       | pause          | 3        |
      | pause      | play           | 0        |
