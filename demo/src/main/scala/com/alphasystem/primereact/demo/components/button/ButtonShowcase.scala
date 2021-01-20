package com.alphasystem.primereact.demo.components.button

import com.alphasystem.primereact.component.badge.BadgeType
import com.alphasystem.primereact.component.button.{
  ButtonBuilder,
  ButtonSize,
  IconPos,
  Severity
}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._
import scalacss.ScalaCssReactImplicits
import com.alphasystem.primereact.demo.ButtonDemoCss
import com.alphasystem.primereact.icons.Icon

object ButtonShowcase extends ScalaCssReactImplicits {

  private val css = ButtonDemoCss

  case class Backend(b: BackendScope[Unit, Unit]) {

    def render: VdomElement = {
      div(cls := "content-section implementation button-demo")(
        div(cls := "card")(
          h5("Basic"),
          ButtonBuilder(label = Some("Submit")).toButton,
          ButtonBuilder(label = Some("Disabled")).toButton(disabled := true),
          ButtonBuilder(label = Some("Link"), link = true).toButton,
          h5("Icons"),
          ButtonBuilder(icon = Some(Right(Icon.Check))).toButton,
          ButtonBuilder(
            label = Some("Submit"),
            icon = Some(Right(Icon.Check))
          ).toButton,
          ButtonBuilder(
            label = Some("Submit"),
            icon = Some(Right(Icon.Check)),
            iconPos = Some(IconPos.Right)
          ).toButton,
          //
          h5("Severities"),
          ButtonBuilder(label = Some("Primary")).toButton,
          ButtonBuilder(
            label = Some("Secondary"),
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            label = Some("Success"),
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            label = Some("Info"),
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            label = Some("Warning"),
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            label = Some("Help"),
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            label = Some("Danger"),
            severity = Some(Severity.Danger)
          ).toButton,
          //
          h5("Raised Buttons"),
          ButtonBuilder(label = Some("Primary"), raised = true).toButton,
          ButtonBuilder(
            label = Some("Secondary"),
            raised = true,
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            label = Some("Success"),
            raised = true,
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            label = Some("Info"),
            raised = true,
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            label = Some("Warning"),
            raised = true,
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            label = Some("Help"),
            raised = true,
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            label = Some("Danger"),
            raised = true,
            severity = Some(Severity.Danger)
          ).toButton,
          //
          h5("Rounded Buttons"),
          ButtonBuilder(label = Some("Primary"), rounded = true).toButton,
          ButtonBuilder(
            label = Some("Secondary"),
            rounded = true,
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            label = Some("Success"),
            rounded = true,
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            label = Some("Info"),
            rounded = true,
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            label = Some("Warning"),
            rounded = true,
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            label = Some("Help"),
            rounded = true,
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            label = Some("Danger"),
            rounded = true,
            severity = Some(Severity.Danger)
          ).toButton,
          //
          h5("Text Buttons"),
          ButtonBuilder(label = Some("Primary"), text = true).toButton,
          ButtonBuilder(
            label = Some("Secondary"),
            text = true,
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            label = Some("Success"),
            text = true,
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            label = Some("Info"),
            text = true,
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            label = Some("Warning"),
            text = true,
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            label = Some("Help"),
            text = true,
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            label = Some("Danger"),
            text = true,
            severity = Some(Severity.Danger)
          ).toButton,
          ButtonBuilder(
            label = Some("Plain"),
            text = true,
            severity = Some(Severity.Plain)
          ).toButton,
          //
          h5("Raised Text Buttons"),
          ButtonBuilder(
            label = Some("Primary"),
            text = true,
            raised = true
          ).toButton,
          ButtonBuilder(
            label = Some("Secondary"),
            text = true,
            raised = true,
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            label = Some("Success"),
            text = true,
            raised = true,
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            label = Some("Info"),
            text = true,
            raised = true,
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            label = Some("Warning"),
            text = true,
            raised = true,
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            label = Some("Help"),
            text = true,
            raised = true,
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            label = Some("Danger"),
            text = true,
            raised = true,
            severity = Some(Severity.Danger)
          ).toButton,
          ButtonBuilder(
            label = Some("Plain"),
            text = true,
            raised = true,
            severity = Some(Severity.Plain)
          ).toButton,
          //
          h5("Outlined Buttons"),
          ButtonBuilder(label = Some("Primary"), outlined = true).toButton,
          ButtonBuilder(
            label = Some("Secondary"),
            outlined = true,
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            label = Some("Success"),
            outlined = true,
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            label = Some("Info"),
            outlined = true,
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            label = Some("Warning"),
            outlined = true,
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            label = Some("Help"),
            outlined = true,
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            label = Some("Danger"),
            outlined = true,
            severity = Some(Severity.Danger)
          ).toButton,
          //
          h5("Rounded Icon Buttons"),
          ButtonBuilder(
            icon = Some(Right(Icon.Check)),
            rounded = true
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Bookmark)),
            rounded = true,
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Search)),
            rounded = true,
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.User)),
            rounded = true,
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Bell)),
            rounded = true,
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Heart)),
            rounded = true,
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Times)),
            rounded = true,
            severity = Some(Severity.Danger)
          ).toButton,
          h5("Rounded Icon Text Buttons"),
          ButtonBuilder(
            icon = Some(Right(Icon.Check)),
            text = true,
            rounded = true
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Bookmark)),
            text = true,
            rounded = true,
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Search)),
            text = true,
            rounded = true,
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.User)),
            text = true,
            rounded = true,
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Bell)),
            text = true,
            rounded = true,
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Heart)),
            text = true,
            rounded = true,
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Times)),
            text = true,
            rounded = true,
            severity = Some(Severity.Danger)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Filter)),
            text = true,
            rounded = true,
            severity = Some(Severity.Plain)
          ).toButton,
          //
          h5("Rounded and Outlined Icon Buttons"),
          ButtonBuilder(
            icon = Some(Right(Icon.Check)),
            outlined = true,
            rounded = true
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Bookmark)),
            outlined = true,
            rounded = true,
            severity = Some(Severity.Secondary)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Search)),
            outlined = true,
            rounded = true,
            severity = Some(Severity.Success)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.User)),
            outlined = true,
            rounded = true,
            severity = Some(Severity.Info)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Bell)),
            outlined = true,
            rounded = true,
            severity = Some(Severity.Warning)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Heart)),
            outlined = true,
            rounded = true,
            severity = Some(Severity.Help)
          ).toButton,
          ButtonBuilder(
            icon = Some(Right(Icon.Times)),
            outlined = true,
            rounded = true,
            severity = Some(Severity.Danger)
          ).toButton,
          //
          h5("Badges"),
          ButtonBuilder(
            label = Some("Emails"),
            badge = Some("8")
          ).toButton,
          ButtonBuilder(
            label = Some("Messages"),
            badge = Some("8"),
            icon = Some(Right(Icon.Users)),
            badgeType = Some(BadgeType.Danger),
            severity = Some(Severity.Warning)
          ).toButton,
          //
          h5("Button Set"),
          span(cls := "p-buttonset")(
            ButtonBuilder(
              label = Some("Save"),
              icon = Some(Right(Icon.Check))
            ).toButton,
            ButtonBuilder(
              label = Some("Delete"),
              icon = Some(Right(Icon.Trash))
            ).toButton,
            ButtonBuilder(
              label = Some("Cancel"),
              icon = Some(Right(Icon.Times))
            ).toButton
          ),
          //
          h5("Sizes"),
          div(cls := "sizes")(
            ButtonBuilder(
              label = Some("Small"),
              icon = Some(Right(Icon.Check)),
              size = Some(ButtonSize.Small)
            ).toButton,
            ButtonBuilder(
              label = Some("Normal"),
              icon = Some(Right(Icon.Check))
            ).toButton,
            ButtonBuilder(
              label = Some("Large"),
              icon = Some(Right(Icon.Check)),
              size = Some(ButtonSize.Large)
            ).toButton
          )
        ) // end of "card"
      ) // end of "content-section implementation"
    }
  }

  private val component = ScalaComponent
    .builder[Unit]("ButtonShowcase")
    .renderBackend[Backend]
    .build

  def apply(): VdomElement = component()
}
