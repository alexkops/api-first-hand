package string_formats_validation.yaml
import play.api.mvc.{Action, Controller}
import play.api.data.validation.Constraint
import de.zalando.play.controllers._
import PlayBodyParsing._
import PlayValidations._

import java.time.LocalDate
import de.zalando.play.controllers.BinaryString
import BinaryString._
import java.time.ZonedDateTime
import de.zalando.play.controllers.Base64String
import Base64String._
// ----- constraints and wrapper validations -----
class StringPostString_optionalOptConstraints(override val instance: String) extends ValidationBase[String] {
    override val reference = "⌿paths⌿/string⌿post⌿string_optional⌿Opt"
    override def constraints: Seq[Constraint[String]] =
        Seq(maxLength(10), minLength(0), pattern("""/[1-9][A-Z0-9]*/""".r))
}
class StringPostString_optionalOptValidator(instance: String) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿string_optional⌿Opt"
    override val validators = Seq(new StringPostString_optionalOptConstraints(instance))
}
class StringPostDate_time_requiredConstraints(override val instance: ZonedDateTime) extends ValidationBase[ZonedDateTime] {
    override val reference = "⌿paths⌿/string⌿post⌿date_time_required"
    override def constraints: Seq[Constraint[ZonedDateTime]] =
        Seq()
}
class StringPostDate_time_requiredValidator(instance: ZonedDateTime) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿date_time_required"
    override val validators = Seq(new StringPostDate_time_requiredConstraints(instance))
}
class StringPostDate_requiredConstraints(override val instance: LocalDate) extends ValidationBase[LocalDate] {
    override val reference = "⌿paths⌿/string⌿post⌿date_required"
    override def constraints: Seq[Constraint[LocalDate]] =
        Seq()
}
class StringPostDate_requiredValidator(instance: LocalDate) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿date_required"
    override val validators = Seq(new StringPostDate_requiredConstraints(instance))
}
class StringPostPassword_optionalOptConstraints(override val instance: String) extends ValidationBase[String] {
    override val reference = "⌿paths⌿/string⌿post⌿password_optional⌿Opt"
    override def constraints: Seq[Constraint[String]] =
        Seq(maxLength(10), minLength(0), pattern("""/[1-9][A-Z0-9]*/""".r))
}
class StringPostPassword_optionalOptValidator(instance: String) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿password_optional⌿Opt"
    override val validators = Seq(new StringPostPassword_optionalOptConstraints(instance))
}
class StringPostDate_optionalOptConstraints(override val instance: LocalDate) extends ValidationBase[LocalDate] {
    override val reference = "⌿paths⌿/string⌿post⌿date_optional⌿Opt"
    override def constraints: Seq[Constraint[LocalDate]] =
        Seq()
}
class StringPostDate_optionalOptValidator(instance: LocalDate) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿date_optional⌿Opt"
    override val validators = Seq(new StringPostDate_optionalOptConstraints(instance))
}
class StringPostString_requiredConstraints(override val instance: String) extends ValidationBase[String] {
    override val reference = "⌿paths⌿/string⌿post⌿string_required"
    override def constraints: Seq[Constraint[String]] =
        Seq(maxLength(100), minLength(10), pattern("""/[1-9][A-Z0-9]*/""".r))
}
class StringPostString_requiredValidator(instance: String) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿string_required"
    override val validators = Seq(new StringPostString_requiredConstraints(instance))
}
class StringPostBinary_optionalOptConstraints(override val instance: String) extends ValidationBase[String] {
    override val reference = "⌿paths⌿/string⌿post⌿binary_optional⌿Opt"
    override def constraints: Seq[Constraint[String]] =
        Seq(maxLength(110), minLength(10), pattern("""/[1-9][A-Z0-9]*/""".r))
}
class StringPostBinary_optionalOptValidator(instance: BinaryString) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿binary_optional⌿Opt"
    override val validators = Seq(new StringPostBinary_optionalOptConstraints(instance))
}
class StringPostPassword_requiredConstraints(override val instance: String) extends ValidationBase[String] {
    override val reference = "⌿paths⌿/string⌿post⌿password_required"
    override def constraints: Seq[Constraint[String]] =
        Seq(maxLength(10), minLength(0), pattern("""/[1-9][A-Z0-9]*/""".r))
}
class StringPostPassword_requiredValidator(instance: String) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿password_required"
    override val validators = Seq(new StringPostPassword_requiredConstraints(instance))
}
class String2PostBinary_requiredConstraints(override val instance: String) extends ValidationBase[String] {
    override val reference = "⌿paths⌿/string2⌿post⌿binary_required"
    override def constraints: Seq[Constraint[String]] =
        Seq(maxLength(10), minLength(0), pattern("""/[1-9][A-Z0-9]*/""".r))
}
class String2PostBinary_requiredValidator(instance: BinaryString) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string2⌿post⌿binary_required"
    override val validators = Seq(new String2PostBinary_requiredConstraints(instance))
}
class StringPostBase64requiredConstraints(override val instance: String) extends ValidationBase[String] {
    override val reference = "⌿paths⌿/string⌿post⌿base64required"
    override def constraints: Seq[Constraint[String]] =
        Seq(maxLength(10), minLength(0), pattern("""/[1-9][A-Z0-9]*/""".r))
}
class StringPostBase64requiredValidator(instance: Base64String) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿base64required"
    override val validators = Seq(new StringPostBase64requiredConstraints(instance))
}
class StringPostDate_time_optionalOptConstraints(override val instance: ZonedDateTime) extends ValidationBase[ZonedDateTime] {
    override val reference = "⌿paths⌿/string⌿post⌿date_time_optional⌿Opt"
    override def constraints: Seq[Constraint[ZonedDateTime]] =
        Seq()
}
class StringPostDate_time_optionalOptValidator(instance: ZonedDateTime) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿date_time_optional⌿Opt"
    override val validators = Seq(new StringPostDate_time_optionalOptConstraints(instance))
}
class StringPostBase64optionalOptConstraints(override val instance: String) extends ValidationBase[String] {
    override val reference = "⌿paths⌿/string⌿post⌿base64optional⌿Opt"
    override def constraints: Seq[Constraint[String]] =
        Seq(maxLength(10), minLength(0), pattern("""/[1-9][A-Z0-9]*/""".r))
}
class StringPostBase64optionalOptValidator(instance: Base64String) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿base64optional⌿Opt"
    override val validators = Seq(new StringPostBase64optionalOptConstraints(instance))
}
// ----- complex type validators -----

// ----- option delegating validators -----
class StringPostString_optionalValidator(instance: StringPostString_optional) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿string_optional"
    override val validators = instance.toSeq.map { new StringPostString_optionalOptValidator(_) }
}
class StringPostPassword_optionalValidator(instance: StringPostPassword_optional) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿password_optional"
    override val validators = instance.toSeq.map { new StringPostPassword_optionalOptValidator(_) }
}
class StringPostDate_optionalValidator(instance: StringPostDate_optional) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿date_optional"
    override val validators = instance.toSeq.map { new StringPostDate_optionalOptValidator(_) }
}
class StringPostBinary_optionalValidator(instance: StringPostBinary_optional) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿binary_optional"
    override val validators = instance.toSeq.map { new StringPostBinary_optionalOptValidator(_) }
}
class StringPostDate_time_optionalValidator(instance: StringPostDate_time_optional) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿date_time_optional"
    override val validators = instance.toSeq.map { new StringPostDate_time_optionalOptValidator(_) }
}
class StringPostBase64optionalValidator(instance: StringPostBase64optional) extends RecursiveValidator {
    override val reference = "⌿paths⌿/string⌿post⌿base64optional"
    override val validators = instance.toSeq.map { new StringPostBase64optionalOptValidator(_) }
}
// ----- array delegating validators -----
// ----- catch all simple validators -----
// ----- composite validators -----
// ----- call validations -----
class StringPostValidator(string_required: String, password_optional: StringPostPassword_optional, date_required: LocalDate, binary_optional: StringPostBinary_optional, date_optional: StringPostDate_optional, base64required: Base64String, base64optional: StringPostBase64optional, string_optional: StringPostString_optional, date_time_required: ZonedDateTime, password_required: String, date_time_optional: StringPostDate_time_optional) extends RecursiveValidator {
    override val reference = "⌿paths⌿string⌿post"
    override val validators = Seq(
        new StringPostString_requiredValidator(string_required), 
    
        new StringPostPassword_optionalValidator(password_optional), 
    
        new StringPostDate_requiredValidator(date_required), 
    
        new StringPostBinary_optionalValidator(binary_optional), 
    
        new StringPostDate_optionalValidator(date_optional), 
    
        new StringPostBase64requiredValidator(base64required), 
    
        new StringPostBase64optionalValidator(base64optional), 
    
        new StringPostString_optionalValidator(string_optional), 
    
        new StringPostDate_time_requiredValidator(date_time_required), 
    
        new StringPostPassword_requiredValidator(password_required), 
    
        new StringPostDate_time_optionalValidator(date_time_optional)
    
    )
}
class String2PostValidator(binary_required: BinaryString) extends RecursiveValidator {
    override val reference = "⌿paths⌿string2⌿post"
    override val validators = Seq(
        new String2PostBinary_requiredValidator(binary_required)
    
    )
}
